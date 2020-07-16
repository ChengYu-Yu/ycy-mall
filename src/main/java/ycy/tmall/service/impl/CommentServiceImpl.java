package ycy.tmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ycy.tmall.dao.CommentMapper;
import ycy.tmall.domain.CommentExample;
import ycy.tmall.domain.Order;
import ycy.tmall.domain.OrderItem;
import ycy.tmall.service.impl.base.BaseServiceImpl;
import ycy.tmall.service.interfaze.ICommentService;
import ycy.tmall.service.interfaze.IOrderItemService;
import ycy.tmall.service.interfaze.IOrderService;

import java.util.List;

@Service
public class CommentServiceImpl extends BaseServiceImpl<CommentMapper, CommentExample> implements ICommentService {
    @Autowired
    IOrderItemService orderItemService;

    @Autowired
    IOrderService orderService;

    @Override
    public boolean checkFinishComment(Order order) {
        List<OrderItem> orderItems = order.getOrderItems();
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getComment() == null) {
                return false;
            }
        }
        return true;
    }
}
