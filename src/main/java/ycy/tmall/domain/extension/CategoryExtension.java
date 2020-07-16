package ycy.tmall.domain.extension;

import ycy.tmall.annotation.ormAnnaotation.JoinColumn;
import ycy.tmall.annotation.ormAnnaotation.OneToMany;
import ycy.tmall.domain.Product;
import ycy.tmall.domain.base.BaseDomain;

import java.util.List;

public class CategoryExtension extends BaseDomain {
    @OneToMany
    @JoinColumn(name = "cid")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getImgPath() {
        return getId() + ".jpg";
    }
}
