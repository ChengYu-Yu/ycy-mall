package ycy.tmall.dao.orm;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import ycy.tmall.annotation.ormAnnaotation.Enumerated;
import ycy.tmall.annotation.ormAnnaotation.JoinColumn;
import ycy.tmall.annotation.ormAnnaotation.ManyToOne;
import ycy.tmall.annotation.ormAnnaotation.OneToMany;
import ycy.tmall.domain.base.BaseExample;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 通用mapper核心类 /处理一对多，多对一的插入
 */
@SuppressWarnings("unchecked")
public class Mapper4ORM {
    Object mapper;
    private Class mapperInterface;
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public Object getMapper(Class mapperInterface) throws Exception {
        return sqlSessionTemplate.getMapper(mapperInterface);
    }

    void setMybatisMapper(Class mapperInterface) throws Exception {
        this.mapperInterface = mapperInterface;
        mapper = getMapper(mapperInterface);
    }

    public BaseExample getExample(Class mapperInterface) throws Exception {
        ParameterizedType t = (ParameterizedType) mapperInterface.getGenericInterfaces()[0];
        Class exampleClass = (Class) t.getActualTypeArguments()[1];
        return (BaseExample) exampleClass.newInstance();
    }


    public Class getMapperInterfaceByDomain(Class DomainClass) throws Exception {
        ParameterizedType t = (ParameterizedType) DomainClass.getGenericInterfaces()[0];
        return (Class) t.getActualTypeArguments()[0];
    }

    /**
     * 获取一个类里，含指定 annotation 的所有 Filed
     *
     * @param objectClass     类
     * @param annotationClass 指定annotation
     * @return 所有filed
     */
    List<Field> getFiledEquals(Class objectClass, Class annotationClass) {
        if (objectClass == null) {
            return null;
        }
        ArrayList<Field> fields = new ArrayList<>();
        for (Class i = objectClass; i != Object.class; i = i.getSuperclass()) {
            fields.addAll(Arrays.asList(i.getDeclaredFields()));
        }
        ArrayList<Field> result = new ArrayList<>();
        for (Field field : fields) {
            if (field.getAnnotation(annotationClass) != null) {
                result.add(field);
            }

        }
        return result;
    }

    /**
     * 处理读取时，多对一 的填充
     * @param object 被填充对象
     * @param depth  当前深度
     * @throws Exception 反射异常
     */
    public void fillManyToOneOnReading(Object object, int depth) throws Exception {
        if (object == null) {
            return;
        }
        Class clazz = object.getClass();

        //1.获取含ManyToOne注解的Field
        List<Field> result = getFiledEquals(clazz, ManyToOne.class);
        for (Field field : result) {
            //2.获取外键的表名
            String joinColumn = field.getAnnotation(JoinColumn.class).name();
            //3.获取需要填充对象的mapper
            Class targetMapperClass = getMapperInterfaceByDomain(field.getType());
            Object targetMapper = getMapper(targetMapperClass);
            //4.获取外键值
            Integer joinColumnValue = (Integer) clazz.getMethod("get" + StringUtils.capitalize(joinColumn)).invoke(object);
            if (joinColumn == null) {
                continue;
            }
            //5.配置查询器example
            BaseExample example = getExample(targetMapperClass);
            Object criteria = example.createCriteria();
            //6.配置Criteria（标准）
            criteria.getClass().getMethod("andIdEqualTo",Integer.class).invoke(criteria,joinColumnValue);
            //7.获取结果列表
            List targetResults= (List) targetMapper.getClass().getMethod("selectByExample",example.getClass()).invoke(targetMapper,example);
            //8.判断是否为空 ，不为空插入 filed
            if (targetResults.size() > 0) {
                Object targetResult = targetResults.get(0);
                fillOnReading(targetResult, depth - 1);
                clazz.getMethod("set" + StringUtils.capitalize(field.getName()), targetResult.getClass())
                        .invoke(object, targetResult);
            }
        }
    }

    /**
     * 读取时，处理所有 一对多 的填充
     *
     * @param object 被填充的对象
     * @param depth  当前深度
     * @throws Exception 反射异常
     */
    public void fillOneToManyOnReading(Object object, int depth) throws Exception {
        if (object == null) {
            return;
        }
        Class clazz = object.getClass();
        // 获取所有 ManyToOne注解的Filed
        List<Field> result = getFiledEquals(clazz, OneToMany.class);
        for (Field field : result) {
            //获取外键的表名
            String joinColumn = field.getAnnotation(JoinColumn.class).name();
            //得到其Generic的类型
            Type genericType = field.getGenericType();
            ParameterizedType pt = (ParameterizedType) genericType;
            //得到List泛型里的目标类型对象
            Class targetClass = (Class) pt.getActualTypeArguments()[0];
            //获取要填充对象的mapper
            Class targetMapperClass = getMapperInterfaceByDomain(targetClass);
            Object targetMapper = getMapper(targetMapperClass);
            //获取外键值
            Integer joinColumnValue = (Integer) clazz.
                    getMethod("getId").invoke(object);
            //配置查询器example
            BaseExample example = getExample(targetMapperClass);
            Object criteria = example.createCriteria();
            // 配置criteria
            criteria.getClass().getMethod("and" + StringUtils.capitalize(joinColumn) + "EqualTo", Integer.class).invoke(criteria, joinColumnValue);
            //查询,获取结果列表
            List targetResults = (List) targetMapper.getClass().getMethod("selectByExample", example.getClass()).
                    invoke(targetMapper, example);
            for (int i = 0; i < targetResults.size(); i++) {
                Object item = targetResults.get(i);
                fillOnReading(item, depth - 1);
                targetResults.set(i, item);
            }
            //插入 filed
            clazz.getMethod("set" + StringUtils.capitalize(field.getName()), List.class)
                    .invoke(object, targetResults);

        }
    }

    /**
     * 读取时，处理所有 Enum 的填充
     *
     * @param object 被填充的对象
     * @throws Exception 反射异常
     */
    public void fillEnumOnReading(Object object) throws Exception {
        if (object == null) {
            return;
        }
        Class clazz = object.getClass();
        // 获取所有 ManyToOne注解的Filed
        List<Field> result =getFiledEquals(clazz, Enumerated.class);
        for (Field field : result) {
            //获取Enum对应的，String类型的变量名
            String varName = field.getAnnotation(Enumerated.class).var();

            //获取值
            String enumString = (String) clazz.
                    getMethod("get" + StringUtils.capitalize(varName)).invoke(object);

            // 转成Enum，插回 filed
            Enum resultObj = Enum.valueOf((Class<Enum>) field.getType(), enumString);
            clazz.getMethod("set" + StringUtils.capitalize(field.getName()), resultObj.getClass())
                    .invoke(object, resultObj);

        }
    }

    /**
     * 写入时，处理所有 Enum 的填充
     *
     * @param object 被填充的对象
     * @throws Exception 反射异常
     */
    public void fillEnumOnWriting(Object object) throws Exception {
        if (object == null) {
            return;
        }
        Class clazz = object.getClass();
        // 获取所有 ManyToOne注解的Filed
        List<Field> result = getFiledEquals(clazz, Enumerated.class);
        for (Field field : result) {
            //获取Enum对应的，String类型的变量名
            String varName = field.getAnnotation(Enumerated.class).var();

            //获取 Enum
            Enum enumObj = (Enum) clazz.
                    getMethod("get" + StringUtils.capitalize(field.getName())).invoke(object);

            // 转成 String，插回 varName
            String enumString = enumObj.name();
            clazz.getMethod("set" + StringUtils.capitalize(varName), String.class)
                    .invoke(object, enumString);
        }
    }

    /**
     * 写入时，处理所有 ManyToOne 的填充
     *
     * @param object 被填充的对象
     * @throws Exception 反射异常
     */
    public void fillManyToOneOnWriting(Object object) throws Exception {
        if (object == null) {
            return;
        }
        Class clazz = object.getClass();
        // 获取所有 ManyToOne注解的Filed
        List<Field> result = getFiledEquals(clazz, ManyToOne.class);
        for (Field field : result) {
            //获取One端的变量名
            String columnName = field.getAnnotation(JoinColumn.class).name();

            //获取One的对象
            Object targetObj = clazz
                    .getMethod("get" + StringUtils.capitalize(field.getName()))
                    .invoke(object);
            if (targetObj == null) {
                continue;
            }
            //获取 获取 id 值
            int id = (int) targetObj.getClass().
                    getMethod("getId").invoke(targetObj);

            // 插回 columnName

            clazz.getMethod("set" + StringUtils.capitalize(columnName), Integer.class)
                    .invoke(object, id);
        }
    }


    /**
     * 读取时填充数据，递归调用上面的方法
     * @param object 对象
     * @param depth 当前递归深度
     * @throws Exception 反射异常
     */
    public void fillOnReading(Object object, int depth) throws Exception {
        if (object == null) {
            return;
        }
        if (depth <= 0) {
            return;
        }

        // 处理 ManyToOne
        fillManyToOneOnReading(object, depth);
        // 处理 OneToMany
        fillOneToManyOnReading(object, depth);
        // 处理 Enumerated
        fillEnumOnReading(object);

    }

    /**
     * 写入时填充数据，递归调用上面的方法
     * @param object 对象
     * @throws Exception 反射异常
     */
    public void fillOnWriting(Object object) throws Exception {
        if (object == null) {
            return;
        }
        // 处理 Enumerated
        fillEnumOnWriting(object);
        // 处理 ManyToOne
        fillManyToOneOnWriting(object);
    }

}
