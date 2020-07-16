package ycy.tmall.service.interfaze.base;

import ycy.tmall.domain.base.BaseDomain;
import ycy.tmall.service.impl.base.BaseServiceImpl;

import java.util.List;

public interface BaseService extends Service4Dao {
    /**
     * 添加（保存）数据
     *
     * @param domain 添加的数据
     * @return 受影响行数
     * @throws Exception
     */
    public Integer add(BaseDomain domain) throws Exception;

    /**
     * 更新数据
     *
     * @param domain 更新的数据
     * @throws Exception
     */
    public void update(BaseDomain domain) throws Exception;

    /**
     * 更新一个列表，用于一次性更改多个对象，且每个对象只传入一个新值的情况
     *
     * @param ids
     * @param values
     * @param changeFieldName 新值的字段
     * @throws Exception
     */
    public void update(Integer[] ids, String[] values, String changeFieldName) throws Exception;

    /**
     * 软删除，通过调用该对象的setDeleteAt方法，向数据库中插入deleteAt日期，并更新
     * 并不会真的删除数据库中的数据
     *
     * @param domain
     * @throws Exception
     */
    public void delete(BaseDomain domain) throws Exception;

    /**
     * 指定表，指定id的查询
     *
     * @param mapperInterface 指定的表，形式为Domain的类对象
     * @param id    要获取的id
     * @return 指定表，指定id的一行数据
     * @throws Exception
     */
    public BaseDomain get(Class mapperInterface, int id) throws Exception;

    /**
     * 指定id的查询
     *
     * @param id 数据库中的id
     * @return 对应该id的一行数据
     * @throws Exception
     */
    public BaseDomain get(int id) throws Exception;

    /**
     * @param id    数据库中的id
     * @param depth 遍历填充的深度
     * @return 自动识别表的对应id的一行数据
     * @throws Exception
     */
    public BaseDomain get(int id, int depth) throws Exception;

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
     * @see BaseServiceImpl
     */
    public List list(Object... paramAndObjects) throws Exception;

    /**
     * @param paramAndObjects 同上
     * @return 只返回第一个
     */
    public Object getOne(Object... paramAndObjects) throws Exception;
}
