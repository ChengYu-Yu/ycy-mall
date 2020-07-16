package ycy.tmall.service.impl;

import org.springframework.stereotype.Service;
import ycy.tmall.dao.CartItemMapper;
import ycy.tmall.domain.CartItem;
import ycy.tmall.domain.CartItemExample;
import ycy.tmall.service.impl.base.BaseServiceImpl;
import ycy.tmall.service.interfaze.ICartItemService;

@Service
public class CartItemServiceImpl extends BaseServiceImpl<CartItemMapper, CartItemExample> implements ICartItemService {
}
