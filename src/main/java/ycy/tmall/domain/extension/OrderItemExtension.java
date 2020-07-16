package ycy.tmall.domain.extension;

import ycy.tmall.annotation.ormAnnaotation.JoinColumn;
import ycy.tmall.annotation.ormAnnaotation.ManyToOne;

import ycy.tmall.domain.Comment;
import ycy.tmall.domain.Order;
import ycy.tmall.domain.Product;
import ycy.tmall.domain.base.BaseDomain;

public class OrderItemExtension extends BaseDomain {
    @ManyToOne
    @JoinColumn(name="pid")
    private Product product;
    @ManyToOne
    @JoinColumn(name="oid")
    private Order order;
    @ManyToOne
    @JoinColumn(name="cmid")
    private Comment comment;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
