package ycy.tmall.domain.extension;

import ycy.tmall.annotation.ormAnnaotation.Enumerated;
import ycy.tmall.annotation.ormAnnaotation.JoinColumn;
import ycy.tmall.annotation.ormAnnaotation.ManyToOne;
import ycy.tmall.annotation.ormAnnaotation.OneToMany;

import ycy.tmall.domain.OrderItem;
import ycy.tmall.domain.User;
import ycy.tmall.domain.base.BaseDomain;

import java.util.List;

public class OrderExtension extends BaseDomain {
    @ManyToOne
    @JoinColumn(name="uid")
    private User user;
    @Enumerated(var = "status")
    private Status statusEnum;
    @OneToMany
    @JoinColumn(name = "oid")
    private List<OrderItem> orderItems;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Status getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(Status statusEnum) {
        this.statusEnum = statusEnum;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String getStatusText() {
        return statusEnum.getName();
    }

    public void setStatus(Status statusEnum) {
        this.statusEnum = statusEnum;
    }

    public enum Status{
        waitPay("待付款"),
        waitDeliver("待发货"),
        waitConfirm("待收货"),
        waitComment("待评论"),
        finish("完成订单"),
        deleted("已删除");

        private String name;

        private Status(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }}

