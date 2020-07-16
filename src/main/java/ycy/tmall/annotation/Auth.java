package ycy.tmall.annotation;

import ycy.tmall.domain.User;

import java.lang.annotation.*;

/**
 *用于权限鉴定
 *指定只能加载在 方法 或者 类 上面，指定最低的可访问权限，低于此等级的用户组不能调用该方法或类
 * 若类上已配置，方法上不必配置，否则会覆盖类上面的配置
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Inherited
public @interface Auth {
    User.Group value();
}
