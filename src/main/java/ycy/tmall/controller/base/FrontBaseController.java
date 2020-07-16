package ycy.tmall.controller.base;

import ycy.tmall.annotation.Auth;
import ycy.tmall.domain.User;

/**
 * Controller前台基类，定义权限
 */
@Auth(User.Group.unLogin)
public class FrontBaseController extends BaseController{
}
