package ycy.tmall.controller.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ycy.tmall.service.interfaze.*;
import ycy.tmall.util.FileUtil;

import javax.servlet.http.HttpServletRequest;

public class BaseController {
    @Autowired
    public ICartItemService cartItemService;
    @Autowired
    public IConfigService configService;
    @Autowired
    public ICommentService commentService;
    @Autowired
    public IUserService userService;
    @Autowired
    public ICategoryService categoryService;
    @Autowired
    public IOrderItemService orderItemService;
    @Autowired
    public IOrderService orderService;
    @Autowired
    public IProductService productService;
    @Autowired
    public IProductImageService productImageService;
    @Autowired
    public IPropertyService propertyService;
    @Autowired
    public IPropertyValueService propertyValueService;
    @Autowired
    public FileUtil fileUtil;

    /**
     * 全局异常处理
     * @param request
     * @param e
     * @return
     */
@ExceptionHandler
    public String handlerException(HttpServletRequest request,Exception e){
        e.printStackTrace();
        return "500";
    }


}
