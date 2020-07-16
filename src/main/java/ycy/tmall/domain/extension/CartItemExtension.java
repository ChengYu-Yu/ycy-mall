package ycy.tmall.domain.extension;

import ycy.tmall.annotation.ormAnnaotation.JoinColumn;
import ycy.tmall.annotation.ormAnnaotation.ManyToOne;
import ycy.tmall.domain.Product;
import ycy.tmall.domain.User;
import ycy.tmall.domain.base.BaseDomain;

public class CartItemExtension extends BaseDomain {
    @ManyToOne
    @JoinColumn(name = "pid")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
