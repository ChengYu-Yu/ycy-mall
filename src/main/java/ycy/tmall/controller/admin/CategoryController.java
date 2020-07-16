package ycy.tmall.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ycy.tmall.annotation.Auth;
import ycy.tmall.annotation.Nullable;
import ycy.tmall.controller.base.AdminBaseController;
import ycy.tmall.domain.Category;
import ycy.tmall.domain.User;
import ycy.tmall.domain.extension.UserExtension;
import ycy.tmall.util.Pagination;
import ycy.tmall.util.UploadedImageFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController extends AdminBaseController {
    @Auth(User.Group.admin)
    @RequestMapping("list")
    public String list(Model model, Pagination pagination) throws Exception {
        List<Category> categories = categoryService.list("pagination", pagination, "order", "recommend desc, id desc");
        model.addAttribute("categories", categories);
        return "admin/listCategory";
    }

    @RequestMapping("add")
    public String add(String name, Integer recommend, UploadedImageFile uploadedImageFile) throws Exception {
        Category category = new Category();
        category.setName(name);
        category.setRecommend(recommend);
        categoryService.add(category);
        fileUtil.saveImg(uploadedImageFile, "category", category.getId() + ".jpg");
        return "redirect:list";
    }

    @Auth(User.Group.admin)
    @RequestMapping("edit")
    public String edit(Integer id, Model model) throws Exception {
        Category category = (Category) categoryService.get(id);
        model.addAttribute(category);
        return "admin/editCategory";
    }

    @RequestMapping("update")
    public String update(Integer id, String name, Integer recommend, @Nullable UploadedImageFile uploadedImageFile, HttpSession session) throws Exception {
        Category category = (Category) categoryService.get(id);
        category.setRecommend(recommend);
        category.setName(name);
        categoryService.add(category);
        if (uploadedImageFile.getImage().getSize() > 0) {
            fileUtil.saveImg(uploadedImageFile, "category", category.getId() + ".jpg");
        }
        session.removeAttribute("cs");
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Integer id, HttpSession session) throws Exception {
        categoryService.delete(categoryService.get(id));
        session.removeAttribute("cs");
        return "redirect:list";
    }
}
