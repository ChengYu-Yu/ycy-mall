package ycy.tmall.domain;

import java.math.BigDecimal;
import ycy.tmall.dao.OrderItemMapper;
import ycy.tmall.domain.extension.OrderItemExtension;
import ycy.tmall.domain.orm.DomainMapper;

public class OrderItem extends OrderItemExtension implements DomainMapper<OrderItemMapper> {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderitem.oid
     *
     * @mbggenerated
     */
    private Integer oid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderitem.pid
     *
     * @mbggenerated
     */
    private Integer pid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderitem.cmid
     *
     * @mbggenerated
     */
    private Integer cmid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderitem.number
     *
     * @mbggenerated
     */
    private Integer number;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column orderitem.sum
     *
     * @mbggenerated
     */
    private BigDecimal sum;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderitem.oid
     *
     * @return the value of orderitem.oid
     *
     * @mbggenerated
     */
    public Integer getOid() {
        return oid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderitem.oid
     *
     * @param oid the value for orderitem.oid
     *
     * @mbggenerated
     */
    public void setOid(Integer oid) {
        this.oid = oid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderitem.pid
     *
     * @return the value of orderitem.pid
     *
     * @mbggenerated
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderitem.pid
     *
     * @param pid the value for orderitem.pid
     *
     * @mbggenerated
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderitem.cmid
     *
     * @return the value of orderitem.cmid
     *
     * @mbggenerated
     */
    public Integer getCmid() {
        return cmid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderitem.cmid
     *
     * @param cmid the value for orderitem.cmid
     *
     * @mbggenerated
     */
    public void setCmid(Integer cmid) {
        this.cmid = cmid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderitem.number
     *
     * @return the value of orderitem.number
     *
     * @mbggenerated
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderitem.number
     *
     * @param number the value for orderitem.number
     *
     * @mbggenerated
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column orderitem.sum
     *
     * @return the value of orderitem.sum
     *
     * @mbggenerated
     */
    public BigDecimal getSum() {
        return sum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column orderitem.sum
     *
     * @param sum the value for orderitem.sum
     *
     * @mbggenerated
     */
    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}