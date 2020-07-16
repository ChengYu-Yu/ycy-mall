package ycy.tmall.service.impl;

import org.springframework.stereotype.Service;
import ycy.tmall.dao.ProductImageMapper;
import ycy.tmall.domain.ProductImageExample;
import ycy.tmall.service.impl.base.BaseServiceImpl;
import ycy.tmall.service.interfaze.IProductImageService;
@Service
public class ProductImageServiceImpl extends BaseServiceImpl<ProductImageMapper, ProductImageExample> implements IProductImageService {
}
