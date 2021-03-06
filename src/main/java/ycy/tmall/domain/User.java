package ycy.tmall.domain;

import ycy.tmall.dao.UserMapper;
import ycy.tmall.domain.extension.UserExtension;
import ycy.tmall.domain.orm.DomainMapper;

public class User extends UserExtension implements DomainMapper<UserMapper> {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.group_
     *
     * @mbggenerated
     */
    private String group_;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.name
     *
     * @return the value of user.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.name
     *
     * @param name the value for user.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.group_
     *
     * @return the value of user.group_
     *
     * @mbggenerated
     */
    public String getGroup_() {
        return group_;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.group_
     *
     * @param group_ the value for user.group_
     *
     * @mbggenerated
     */
    public void setGroup_(String group_) {
        this.group_ = group_ == null ? null : group_.trim();
    }
}