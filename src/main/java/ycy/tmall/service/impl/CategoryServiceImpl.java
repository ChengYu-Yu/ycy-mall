package ycy.tmall.service.impl;

import org.springframework.stereotype.Service;
import ycy.tmall.dao.CategoryMapper;
import ycy.tmall.domain.CategoryExample;
import ycy.tmall.service.impl.base.BaseServiceImpl;
import ycy.tmall.service.interfaze.ICartItemService;
import ycy.tmall.service.interfaze.ICategoryService;

@Service
public class CategoryServiceImpl extends BaseServiceImpl<CategoryMapper, CategoryExample> implements ICategoryService {
}
