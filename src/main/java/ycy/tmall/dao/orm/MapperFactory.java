package ycy.tmall.dao.orm;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MapperFactory {
    @Resource
private SqlSessionTemplate sqlSessionTemplate;

    public Mapper getMapper(Class mapperInterface) throws Exception {
        Mapper mapper = new Mapper();
        mapper.setSqlSessionTemplate(sqlSessionTemplate);
        mapper.setMybatisMapper(mapperInterface);
        return mapper;
    }
}
