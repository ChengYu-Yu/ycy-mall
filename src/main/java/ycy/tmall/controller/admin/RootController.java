package ycy.tmall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ycy.tmall.annotation.Auth;
import ycy.tmall.controller.base.AdminBaseController;
import ycy.tmall.domain.User;

@Controller
@RequestMapping("/admin/")
public class RootController extends AdminBaseController {
    @Auth(User.Group.admin)
    @RequestMapping("/")
    public String root() {
        return "redirect:category/list";
    }
}
