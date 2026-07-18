package cursor.mall.controller;

import cursor.mall.model.UserSessionView;
import cursor.mall.service.interfaces.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * 「我的」页面控制器：支持已登录与退出后的游客态。
 * （由 Curosr 自动生成）
 */
@Controller
public class MeController {

    /** 认证服务。 */
    private final AuthService authService;

    /**
     * 构造注入认证服务。
     * （由 Curosr 自动生成）
     *
     * @param authService 认证服务
     */
    public MeController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * 打开「我的」页；未登录展示登录/注册入口（需求 0.4）。
     * （由 Curosr 自动生成）
     *
     * @param session HTTP Session
     * @param model   视图模型
     * @return 转发到 me.jsp
     */
    @GetMapping("/me")
    public String me(HttpSession session, Model model) {
        UserSessionView user = authService.currentUser(session);
        model.addAttribute("user", user);
        model.addAttribute("currentTab", "me");
        return "forward:/WEB-INF/jsp/me.jsp";
    }
}
