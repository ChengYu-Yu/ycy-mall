package ycy.tmall.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import ycy.tmall.dao.base.BaseDao;
import ycy.tmall.domain.PropertyValue;
import ycy.tmall.domain.PropertyValueExample;

public interface PropertyValueMapper extends BaseDao<PropertyValue, PropertyValueExample> {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table property_value
     *
     * @mbggenerated
     */
    int countByExample(PropertyValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table property_value
     *
     * @mbggenerated
     */
    int deleteByExample(PropertyValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table property_value
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table property_value
     *
     * @mbggenerated
     */
    int insert(PropertyValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table property_value
     *
     * @mbggenerated
     */
    int insertSelective(PropertyValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table property_value
     *
     * @mbggenerated
     */
    List<PropertyValue> selectByExample(PropertyValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table property_value
     *
     * @mbggenerated
     */
    PropertyValue selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table property_value
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") PropertyValue record, @Param("example") PropertyValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table property_value
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") PropertyValue record, @Param("example") PropertyValueExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table property_value
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(PropertyValue record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table property_value
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(PropertyValue record);
}