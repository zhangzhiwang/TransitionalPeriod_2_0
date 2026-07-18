package cursor.website.controller;

import cursor.website.service.interfaces.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 首页页面控制器：组装数据并转发到 home.jsp。
 * （由 Curosr 自动生成）
 */
@Controller
@RequiredArgsConstructor
public class HomeController {

    /** 首页业务服务。 */
    private final HomeService homeService;

    /**
     * 首页入口：/ 与 /home。
     * （由 Curosr 自动生成）
     *
     * @param model 视图模型
     * @return 转发到 home.jsp
     */
    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("home", homeService.buildHomeContent());
        model.addAttribute("currentNav", "home");
        return "forward:/WEB-INF/jsp/home.jsp";
    }
}
