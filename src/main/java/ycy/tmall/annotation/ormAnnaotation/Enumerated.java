package ycy.tmall.annotation.ormAnnaotation;

import java.lang.annotation.*;

/**
 *通用mapper /ORM配置的注解：处理Enum
 * 用在Enum变量上面，指定 var 为从数据库读出的，String类型的 变量
 */
@Target(ElementType.FIELD)//作用域
@Retention(RetentionPolicy.RUNTIME)//生命周期
@Inherited//继承
public @interface Enumerated {
    String var();
}
