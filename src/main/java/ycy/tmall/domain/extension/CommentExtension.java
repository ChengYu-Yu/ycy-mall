package ycy.tmall.domain.extension;

import ycy.tmall.annotation.ormAnnaotation.JoinColumn;
import ycy.tmall.annotation.ormAnnaotation.ManyToOne;
import ycy.tmall.domain.Product;
import ycy.tmall.domain.User;
import ycy.tmall.domain.base.BaseDomain;

public class CommentExtension extends BaseDomain {
    @ManyToOne
    @JoinColumn(name="uid")
    private User user;
    @ManyToOne
    @JoinColumn(name="pid")
    private Product product;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
