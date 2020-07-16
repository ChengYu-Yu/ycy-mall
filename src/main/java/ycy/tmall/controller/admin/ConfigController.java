package ycy.tmall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ycy.tmall.annotation.Auth;
import ycy.tmall.controller.base.AdminBaseController;
import ycy.tmall.domain.Config;
import ycy.tmall.domain.User;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/config")
public class ConfigController extends AdminBaseController {
    @Auth(User.Group.admin)
    @RequestMapping("edit")
    public String edit(Model model) throws Exception {
        List<Config> configs = configService.list();
        model.addAttribute("configs", configs);
        return "admin/editConfig";
    }

    @RequestMapping("update")
    public String update(Integer[] id, String[] value, HttpSession session) throws Exception {
        configService.update(id, value, "value");
        //使设置马上生效
        session.removeAttribute("productImgDir");
        return "redirect:edit";
    }
}
