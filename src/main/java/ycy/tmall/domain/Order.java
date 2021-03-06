package ycy.tmall.domain;

import java.math.BigDecimal;
import java.util.Date;
import ycy.tmall.dao.OrderMapper;
import ycy.tmall.domain.extension.OrderExtension;
import ycy.tmall.domain.orm.DomainMapper;

public class Order extends OrderExtension implements DomainMapper<OrderMapper> {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_.uid
     *
     * @mbggenerated
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_.orderCode
     *
     * @mbggenerated
     */
    private String orderCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_.sum
     *
     * @mbggenerated
     */
    private BigDecimal sum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_.totalNumber
     *
     * @mbggenerated
     */
    private Integer totalNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_.address
     *
     * @mbggenerated
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_.post
     *
     * @mbggenerated
     */
    private String post;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_.receiver
     *
     * @mbggenerated
     */
    private String receiver;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_.mobile
     *
     * @mbggenerated
     */
    private String mobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_.userMessage
     *
     * @mbggenerated
     */
    private String userMessage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_.createDate
     *
     * @mbggenerated
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_.payDate
     *
     * @mbggenerated
     */
    private Date payDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_.deliverDate
     *
     * @mbggenerated
     */
    private Date deliverDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_.confirmDate
     *
     * @mbggenerated
     */
    private Date confirmDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_.uid
     *
     * @return the value of order_.uid
     *
     * @mbggenerated
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_.uid
     *
     * @param uid the value for order_.uid
     *
     * @mbggenerated
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_.orderCode
     *
     * @return the value of order_.orderCode
     *
     * @mbggenerated
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_.orderCode
     *
     * @param orderCode the value for order_.orderCode
     *
     * @mbggenerated
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_.sum
     *
     * @return the value of order_.sum
     *
     * @mbggenerated
     */
    public BigDecimal getSum() {
        return sum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_.sum
     *
     * @param sum the value for order_.sum
     *
     * @mbggenerated
     */
    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_.totalNumber
     *
     * @return the value of order_.totalNumber
     *
     * @mbggenerated
     */
    public Integer getTotalNumber() {
        return totalNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_.totalNumber
     *
     * @param totalNumber the value for order_.totalNumber
     *
     * @mbggenerated
     */
    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_.address
     *
     * @return the value of order_.address
     *
     * @mbggenerated
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_.address
     *
     * @param address the value for order_.address
     *
     * @mbggenerated
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_.post
     *
     * @return the value of order_.post
     *
     * @mbggenerated
     */
    public String getPost() {
        return post;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_.post
     *
     * @param post the value for order_.post
     *
     * @mbggenerated
     */
    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_.receiver
     *
     * @return the value of order_.receiver
     *
     * @mbggenerated
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_.receiver
     *
     * @param receiver the value for order_.receiver
     *
     * @mbggenerated
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_.mobile
     *
     * @return the value of order_.mobile
     *
     * @mbggenerated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_.mobile
     *
     * @param mobile the value for order_.mobile
     *
     * @mbggenerated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_.userMessage
     *
     * @return the value of order_.userMessage
     *
     * @mbggenerated
     */
    public String getUserMessage() {
        return userMessage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_.userMessage
     *
     * @param userMessage the value for order_.userMessage
     *
     * @mbggenerated
     */
    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage == null ? null : userMessage.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_.createDate
     *
     * @return the value of order_.createDate
     *
     * @mbggenerated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_.createDate
     *
     * @param createDate the value for order_.createDate
     *
     * @mbggenerated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_.payDate
     *
     * @return the value of order_.payDate
     *
     * @mbggenerated
     */
    public Date getPayDate() {
        return payDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_.payDate
     *
     * @param payDate the value for order_.payDate
     *
     * @mbggenerated
     */
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_.deliverDate
     *
     * @return the value of order_.deliverDate
     *
     * @mbggenerated
     */
    public Date getDeliverDate() {
        return deliverDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_.deliverDate
     *
     * @param deliverDate the value for order_.deliverDate
     *
     * @mbggenerated
     */
    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_.confirmDate
     *
     * @return the value of order_.confirmDate
     *
     * @mbggenerated
     */
    public Date getConfirmDate() {
        return confirmDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_.confirmDate
     *
     * @param confirmDate the value for order_.confirmDate
     *
     * @mbggenerated
     */
    public void setConfirmDate(Date confirmDate) {
        this.confirmDate = confirmDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_.status
     *
     * @return the value of order_.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_.status
     *
     * @param status the value for order_.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}