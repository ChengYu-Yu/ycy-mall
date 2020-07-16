package ycy.tmall.service.impl;

import org.springframework.stereotype.Service;
import ycy.tmall.dao.PropertyMapper;
import ycy.tmall.domain.PropertyExample;
import ycy.tmall.service.impl.base.BaseServiceImpl;
import ycy.tmall.service.interfaze.IPropertyService;
@Service
public class PropertyServiceImpl extends BaseServiceImpl<PropertyMapper, PropertyExample> implements IPropertyService {
}
