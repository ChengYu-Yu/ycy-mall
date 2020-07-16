package ycy.tmall.service.impl;

import org.springframework.stereotype.Service;
import ycy.tmall.dao.ProductMapper;
import ycy.tmall.domain.ProductExample;
import ycy.tmall.service.impl.base.BaseServiceImpl;
import ycy.tmall.service.interfaze.IProductService;
@Service
public class ProductServiceImpl extends BaseServiceImpl<ProductMapper, ProductExample> implements IProductService {
}
