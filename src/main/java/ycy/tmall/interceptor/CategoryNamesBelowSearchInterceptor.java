package ycy.tmall.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ycy.tmall.domain.Category;
import ycy.tmall.service.interfaze.ICategoryService;
import ycy.tmall.util.Pagination;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 加载分类列表
 */
public class CategoryNamesBelowSearchInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    ICategoryService categoryService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (!(o instanceof HandlerMethod)) {
            return true;
        }
        if (request.getServletContext().getAttribute("cs") != null) {
            return true;
        }
        Pagination pagination = new Pagination();
        pagination.setCount(7);
        List<Category> cs = categoryService
                .list("depth", 1, "pagination", pagination, "recommend_gt", 0);
        request.getServletContext().setAttribute("cs", cs);
        return true;
    }
}
