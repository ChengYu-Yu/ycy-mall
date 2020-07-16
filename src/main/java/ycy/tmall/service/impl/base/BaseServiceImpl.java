package ycy.tmall.service.impl.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import ycy.tmall.domain.base.BaseDomain;
import ycy.tmall.domain.base.BaseExample;
import ycy.tmall.service.interfaze.base.BaseService;
import ycy.tmall.util.Pagination;

import java.rmi.NoSuchObjectException;
import java.util.Date;
import java.util.List;

public class BaseServiceImpl<M, E> extends Service4DaoImpl<M, E> implements BaseService {
    @Override
    public Integer add(BaseDomain domain) throws Exception {
        return mapper.insert(domain);
    }

    @Override
    public void update(BaseDomain domain) throws Exception {
        mapper.updateByPrimaryKey(domain);
    }

    @Override
    public void update(Integer[] ids, String[] values, String changeFieldName) throws Exception {
        for (int i = 0; i < ids.length; i++) {
            int id = ids[i];
            String newValue = values[i];
            //数据库获取对象
            Object objectFromDB = get(id);
            //新值插入旧的对象
            objectFromDB.getClass().getMethod("set" + StringUtils.capitalize(changeFieldName), newValue.getClass()).invoke(objectFromDB, newValue);
            update((BaseDomain) objectFromDB);
        }

    }

    @Override
    public void delete(BaseDomain domain) throws Exception {
        domain.setDeleteAt(new Date());
        mapper.updateByPrimaryKey(domain);
    }

    @Override
    public BaseDomain get(Class mapperInterface, int id) throws Exception {
        mapper.getMapper(mapperInterface);
        BaseDomain domain = (BaseDomain) mapper.selectByPrimaryKey(id);

        return domain;
    }

    @Override
    public BaseDomain get(int id) throws Exception {
        BaseDomain domain = (BaseDomain) mapper.selectByPrimaryKey(id);
        if (domain == null) {
            throw new NoSuchObjectException("请求的id不存在，或者已经被删除");
        }
        return domain;
    }

    @Override
    public BaseDomain get(int id, int depth) throws Exception {
        BaseDomain domain = (BaseDomain) mapper.selectByPrimaryKey(id, depth);
        if (domain == null) {
            throw new NoSuchObjectException("请求的id不存在，或者已经被删除");
        }
        return domain;
    }


    /**
     * @param paramAndObjects (propertyName,object,propertyName,object....)
     *                        例子：productService调用 list("cid",category.getId()) ,可获取所有该分类的 products
     *                        可堆叠使用，UserService 调用 list("name","xxx","password","xxx")可获取符合条件的 user
     *                        支持多条件查询的功能
     *                        order, String                 指定order
     *                        xx, String                    xx列 = String
     *                        xx_like, String               xx列 like String
     *                        xx_gt, int                    xx列 > int
     *                        pagination,paginationObj      处理分页
     *                        depth, int                    通用 mapper 递归 填充的深度
     * @return
     * @throws Exception
     */
    @Override
    public List list(Object... paramAndObjects) throws Exception {
        BaseExample example = getExample();
        Object criteria = example.createCriteria();
        if (paramAndObjects.length % 2 != 0) {
            return null;
        }
        Pagination pagination=null;
        //默认按照id排序
        example.setOrderByClause("id desc");
        //默认对查询进行两次遍历
        int depth=2;
        for (int i = 0; i <paramAndObjects.length ; i+=2) {
            if (paramAndObjects[i].equals("order") && paramAndObjects[i + 1] instanceof String) {
                example.setOrderByClause(paramAndObjects[i + 1].toString());
                continue;
            }
            if (paramAndObjects[i].equals("depth") && paramAndObjects[i + 1] instanceof Integer) {
                depth = (Integer) paramAndObjects[i + 1];
                continue;
            }
            if (paramAndObjects[i].toString().contains("_like") && paramAndObjects[i + 1] instanceof String) {
                String column = StringUtils.replace(paramAndObjects[i].toString(), "_like", "");
                criteria.getClass()
                        .getMethod("and" + StringUtils.capitalize(column) + "Like", String.class)
                        .invoke(criteria, "%" + paramAndObjects[i + 1].toString() + "%");
                continue;
            }
            if (paramAndObjects[i].toString().contains("_gt") && paramAndObjects[i + 1] instanceof Integer) {
                String column = StringUtils.replace(paramAndObjects[i].toString(), "_gt", "");
                criteria.getClass()
                        .getMethod("and" + StringUtils.capitalize(column) + "GreaterThan", Integer.class)
                        .invoke(criteria, paramAndObjects[i + 1]);
                continue;
            }
            if (paramAndObjects[i].equals("pagination") && paramAndObjects[i + 1] instanceof Pagination) {
                pagination = (Pagination) paramAndObjects[i + 1];
                continue;
            }
            criteria.getClass()
                    .getMethod("and" + StringUtils.capitalize(paramAndObjects[i].toString()) + "EqualTo"
                            , paramAndObjects[i + 1].getClass())
                    .invoke(criteria, paramAndObjects[i + 1]);
        }
        List list;
        if (pagination!=null){
            PageHelper.offsetPage(pagination.getStart(),pagination.getCount());
            list=mapper.selectByExample(example,depth);
            pagination.setTotal((int) new PageInfo<>(list).getTotal());
        }
        else {
            list = mapper.selectByExample(example, depth);
        }
        return list;
    }

    @Override
    public Object getOne(Object... paramAndObjects) throws Exception {
        BaseDomain domain = null;
        try {
            domain = (BaseDomain) list(paramAndObjects).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return domain;
    }
}
