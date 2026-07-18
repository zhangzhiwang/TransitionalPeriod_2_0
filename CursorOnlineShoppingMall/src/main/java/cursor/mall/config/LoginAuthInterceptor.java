package cursor.mall.config;

import cursor.mall.common.SessionKeys;
import cursor.mall.model.UserSessionView;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;

/**
 * 登录拦截器：未登录访问受保护页面/API 时跳转登录或返回 401。
 * （由 Curosr 自动生成）
 */
@Component
public class LoginAuthInterceptor implements HandlerInterceptor {

    /**
     * 请求前置校验登录态。
     * （由 Curosr 自动生成）
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理器
     * @return 已登录 true；未登录已处理后 false
     * @throws Exception 写出响应异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession(false);
        if (isLoggedIn(session)) {
            return true;
        }
        String uri = request.getRequestURI();
        String context = request.getContextPath();
        String path = uri;
        if (context != null && !context.isEmpty() && uri.startsWith(context)) {
            path = uri.substring(context.length());
        }
        if (path.startsWith("/api/")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write("{\"code\":401,\"message\":\"未登录\",\"data\":null}");
            return false;
        }
        String loginUrl = context + "/login";
        String redirect = request.getQueryString() == null ? path : path + "?" + request.getQueryString();
        response.sendRedirect(loginUrl + "?redirect=" + java.net.URLEncoder.encode(redirect, "UTF-8"));
        return false;
    }

    /**
     * 判断 Session 是否已登录。
     * （由 Curosr 自动生成）
     *
     * @param session HTTP Session
     * @return 已登录 true
     */
    private boolean isLoggedIn(HttpSession session) {
        if (session == null) {
            return false;
        }
        Object attr = session.getAttribute(SessionKeys.LOGIN_USER);
        if (!(attr instanceof UserSessionView)) {
            return false;
        }
        UserSessionView user = (UserSessionView) attr;
        return user.isLoggedIn() && user.getUserId() != null;
    }
}
