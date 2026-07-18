package cursor.mall.controller;

import cursor.mall.model.HomeContent;
import cursor.mall.service.interfaces.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页页面控制器：注入数据并转发到 JSP。
 * 需登录访问，由 LoginAuthInterceptor 统一拦截。
 * （由 Curosr 自动生成）
 */
@Controller
public class HomeController {

    /** 首页业务服务。 */
    private final HomeService homeService;

    /**
     * 构造注入首页服务。
     * （由 Curosr 自动生成）
     *
     * @param homeService 首页服务
     */
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    /**
     * 打开首页（/ 与 /home）。
     * （由 Curosr 自动生成）
     *
     * @param model Spring MVC 模型
     * @return 转发到 home.jsp
     */
    @GetMapping({"/", "/home"})
    public String home(Model model) {
        HomeContent home = homeService.buildHomeContent();
        model.addAttribute("home", home);
        model.addAttribute("currentTab", "home");
        return "forward:/WEB-INF/jsp/home.jsp";
    }
}
