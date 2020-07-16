package ycy.tmall.service.interfaze.base;

import ycy.tmall.dao.orm.Mapper;

/**
 *Service层处理Dao层的基类，反射获取 BaseService 子类的实际业务子类名称，拉取相应的 dao类和 domain类，
 */
public interface Service4Dao {
    /**
     * @param mapperInterface mapper的接口
     * @return  spring代理过的mapper
     * @throws Exception
     */
    Mapper getMapper(Class mapperInterface) throws  Exception;
}
