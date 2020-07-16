package ycy.tmall.service.impl;

import org.springframework.stereotype.Service;
import ycy.tmall.dao.OrderItemMapper;
import ycy.tmall.domain.OrderItemExample;
import ycy.tmall.service.impl.base.BaseServiceImpl;
import ycy.tmall.service.interfaze.IOrderItemService;

@Service
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItemMapper, OrderItemExample> implements IOrderItemService {
}
