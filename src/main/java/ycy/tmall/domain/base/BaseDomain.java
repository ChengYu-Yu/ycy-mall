package ycy.tmall.domain.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类基类，让自动生成的实体类都继承本类
 */
public class BaseDomain implements Serializable {
    private Integer id;
    private Date deleteAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Date deleteAt) {
        this.deleteAt = deleteAt;
    }
}
