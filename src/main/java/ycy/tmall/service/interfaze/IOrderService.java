package ycy.tmall.service.interfaze;

import ycy.tmall.domain.CartItem;
import ycy.tmall.domain.Order;
import ycy.tmall.service.interfaze.base.BaseService;

import java.util.List;

public interface IOrderService extends BaseService {
    /**
     * 添加订单
     * @param order     订单
     * @param cartItems
     * @throws Exception
     */
    public void createOrder(Order order , List<CartItem> cartItems) throws Exception;

}
