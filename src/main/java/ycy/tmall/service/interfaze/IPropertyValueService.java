package ycy.tmall.service.interfaze;

import ycy.tmall.domain.Product;
import ycy.tmall.service.interfaze.base.BaseService;

public interface IPropertyValueService extends BaseService {
    /**
     * 初始化一个产品的所有参数，即预先插入空数据
     * @param product 要修改的产品
     */
    public void init(Product product) throws Exception;
}
