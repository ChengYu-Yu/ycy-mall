package ycy.tmall.annotation.ormAnnaotation;

import java.lang.annotation.*;

/**
 * 通用mapper /ORM配置注解 ：指定外键
 * 搭配 ManyToOne 和 OneToMany 使用
 * 指定外键的变量名
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface JoinColumn {
    String name();
}
