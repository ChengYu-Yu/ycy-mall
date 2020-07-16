package ycy.tmall.service.interfaze;

import ycy.tmall.domain.Order;
import ycy.tmall.service.interfaze.base.BaseService;

public interface ICommentService extends BaseService {

    /**
     * @param order  待检测的order
     * @return       如果已评论完该订单下的所有商品，则返回true，否则返回false
     */
    public boolean checkFinishComment(Order order);
}
