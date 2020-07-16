package ycy.tmall.domain.extension;

import ycy.tmall.annotation.ormAnnaotation.JoinColumn;
import ycy.tmall.annotation.ormAnnaotation.ManyToOne;
import ycy.tmall.domain.Product;
import ycy.tmall.domain.base.BaseDomain;

public class ProductImageExtension extends BaseDomain {
    @ManyToOne
    @JoinColumn(name = "pid")
    private Product product;

    public enum Type{
        top,detail,cover;
    }
    public String getPath(){
        return getId()+".jpg";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
