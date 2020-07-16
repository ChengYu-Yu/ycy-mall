package ycy.tmall.service.impl;

import org.apache.commons.lang3.RandomUtils;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ycy.tmall.dao.OrderMapper;
import ycy.tmall.domain.*;
import ycy.tmall.domain.extension.OrderExtension;
import ycy.tmall.service.impl.base.BaseServiceImpl;
import ycy.tmall.service.interfaze.ICartItemService;
import ycy.tmall.service.interfaze.IOrderItemService;
import ycy.tmall.service.interfaze.IOrderService;
import ycy.tmall.service.interfaze.IProductService;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderMapper, OrderExample> implements IOrderService {
    @Autowired
    IOrderItemService orderItemService;
    @Autowired
    ICartItemService cartItemService;
    @Autowired
    IProductService productService;

    @Override
    public void createOrder(Order order, List<CartItem> cartItems) throws Exception {
        String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date()) + RandomUtils.nextInt();
        order.setOrderCode(orderCode);
        order.setCreateDate(new Date());
        order.setStatus(Order.Status.waitPay);
        BigDecimal sum = new BigDecimal(0);
        int totalNumber = 0;
        for (CartItem item : cartItems) {
            sum = sum.add(item.getSum());
            totalNumber++;
        }
        order.setSum(sum);
        order.setTotalNumber(totalNumber);
        add(order);
        for (CartItem item : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setNumber(item.getNumber());
            orderItem.setProduct(item.getProduct());
            order.setSum(item.getSum());
            if (item.getId() > 0) {
                cartItemService.delete(item);
            }
            Product product = orderItem.getProduct();
            product.setStock(product.getStock() - item.getNumber());
            product.setSaleCount(product.getSaleCount() + 1);
            productService.update(product);
            orderItemService.add(orderItem);
        }
    }
}
