package cursor.mall.controller;

import cursor.mall.common.SessionKeys;
import cursor.mall.model.UserSessionView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 * 登录 / 注册页面控制器。
 * （由 Curosr 自动生成）
 */
@Controller
public class AuthController {

    /**
     * 打开登录页；已登录则进首页。
     * （由 Curosr 自动生成）
     *
     * @param session HTTP Session
     * @return JSP 转发或重定向
     */
    @GetMapping("/login")
    public String loginPage(HttpSession session) {
        if (alreadyLoggedIn(session)) {
            return "redirect:/home";
        }
        return "forward:/WEB-INF/jsp/login.jsp";
    }

    /**
     * 打开注册页；已登录则进首页。
     * （由 Curosr 自动生成）
     *
     * @param session HTTP Session
     * @return JSP 转发或重定向
     */
    @GetMapping("/register")
    public String registerPage(HttpSession session) {
        if (alreadyLoggedIn(session)) {
            return "redirect:/home";
        }
        return "forward:/WEB-INF/jsp/register.jsp";
    }

    /**
     * 判断是否已登录。
     * （由 Curosr 自动生成）
     *
     * @param session Session
     * @return 已登录 true
     */
    private boolean alreadyLoggedIn(HttpSession session) {
        Object attr = session.getAttribute(SessionKeys.LOGIN_USER);
        if (!(attr instanceof UserSessionView)) {
            return false;
        }
        UserSessionView user = (UserSessionView) attr;
        return user.isLoggedIn() && user.getUserId() != null;
    }
}
