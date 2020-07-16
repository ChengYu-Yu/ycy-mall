package ycy.tmall.service.impl.base;

import org.springframework.beans.factory.InitializingBean;
import ycy.tmall.dao.orm.Mapper;
import ycy.tmall.dao.orm.MapperFactory;
import ycy.tmall.domain.base.BaseExample;
import ycy.tmall.service.interfaze.base.Service4Dao;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;

/**
 * Service层处理Dao层的基类
 * 通过反射获取实际业务子类的名称
 * 从而拉取相应的Domain、Mapper、Example类
 * 代理createCriteria方法和 getSession方法
 * @param <M> Mapper
 * @param <E> Example
 */
public class Service4DaoImpl<M, E> implements Service4Dao, InitializingBean {
    @Resource
    private MapperFactory mapperFactory;

    Mapper mapper;

    /**
     * 加载完service后执行
     * 获取对应Service 和 Mapper
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        mapper = getMapper();

    }

    public Mapper getMapper() throws Exception {
        //获取第一个泛型参数M 的类型
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Class mapperClass = null;
        if (type != null) {
            mapperClass = (Class) type.getActualTypeArguments()[0];
        }
        return getMapper(mapperClass);
    }


    @Override
    public Mapper getMapper(Class mapperInterface) throws Exception {
        return mapperFactory.getMapper(mapperInterface);
    }

    public BaseExample getExample() throws Exception {
        //获取第二个泛型参数E 的类型
        ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
        Class exampleClass = null;
        if (type != null) {
            exampleClass = (Class) type.getActualTypeArguments()[1];
        }
        return (BaseExample) exampleClass.newInstance();
    }
}
