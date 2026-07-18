package cursor.mall.service.interfaces;

import cursor.mall.model.LoginRequest;
import cursor.mall.model.RegisterRequest;
import cursor.mall.model.UserSessionView;

import javax.servlet.http.HttpSession;

/**
 * 登录注册业务接口。
 * （由 Curosr 自动生成）
 */
public interface AuthService {

    /**
     * 向邮箱发送 6 位注册验证码。
     * （由 Curosr 自动生成）
     *
     * @param email 收件邮箱
     */
    void sendRegisterCode(String email);

    /**
     * 校验验证码后注册并写入 mall_user。
     * （由 Curosr 自动生成）
     *
     * @param request 注册请求（含验证码）
     * @return 注册成功的用户视图（未自动登录）
     */
    UserSessionView register(RegisterRequest request);

    /**
     * 用户登录：校验账号密码后写入 Session。
     * （由 Curosr 自动生成）
     *
     * @param request 登录请求
     * @param session HTTP Session
     * @return 登录用户视图
     */
    UserSessionView login(LoginRequest request, HttpSession session);

    /**
     * 退出登录，清除 Session 中的登录态。
     * （由 Curosr 自动生成）
     *
     * @param session HTTP Session
     */
    void logout(HttpSession session);

    /**
     * 读取当前登录用户；未登录返回 loggedIn=false。
     * （由 Curosr 自动生成）
     *
     * @param session HTTP Session
     * @return 用户视图
     */
    UserSessionView currentUser(HttpSession session);
}
