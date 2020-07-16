package ycy.tmall.controller.base;

import ycy.tmall.annotation.Auth;
import ycy.tmall.domain.User;

/**
 * Controller的admin基类，定义权限
 */
@Auth(User.Group.superAdmin)
public class AdminBaseController extends BaseController {
}
