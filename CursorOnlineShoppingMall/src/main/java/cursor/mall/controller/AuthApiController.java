package cursor.mall.controller;

import cursor.mall.common.ApiResponse;
import cursor.mall.model.LoginRequest;
import cursor.mall.model.RegisterRequest;
import cursor.mall.model.SendRegisterCodeRequest;
import cursor.mall.model.UserSessionView;
import cursor.mall.service.interfaces.AuthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 认证相关 JSON API：发验证码、注册、登录、退出、当前用户。
 * （由 Curosr 自动生成）
 */
@RestController
@RequestMapping("/api/auth")
public class AuthApiController {

    /** 认证业务服务。 */
    private final AuthService authService;

    /**
     * 构造注入认证服务。
     * （由 Curosr 自动生成）
     *
     * @param authService 认证服务
     */
    public AuthApiController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * 发送注册邮箱 6 位验证码。
     * （由 Curosr 自动生成）
     *
     * @param request 含邮箱的请求
     * @return 统一响应
     */
    @PostMapping("/send-register-code")
    public ApiResponse<Void> sendRegisterCode(@RequestBody SendRegisterCodeRequest request) {
        try {
            String email = request == null ? null : request.getEmail();
            authService.sendRegisterCode(email);
            return ApiResponse.ok("验证码已发送，请查收邮箱", null);
        } catch (IllegalArgumentException ex) {
            return ApiResponse.fail(400, ex.getMessage());
        } catch (IllegalStateException ex) {
            return ApiResponse.fail(500, ex.getMessage());
        } catch (Exception ex) {
            return ApiResponse.fail(500, "验证码发送失败，请稍后重试");
        }
    }

    /**
     * 用户注册（校验验证码后真实写库）。
     * （由 Curosr 自动生成）
     *
     * @param request 注册请求
     * @return 统一响应
     */
    @PostMapping("/register")
    public ApiResponse<UserSessionView> register(@RequestBody RegisterRequest request) {
        try {
            UserSessionView view = authService.register(request);
            return ApiResponse.ok("注册成功", view);
        } catch (IllegalArgumentException ex) {
            int code = "用户名已存在".equals(ex.getMessage()) || "邮箱已被注册".equals(ex.getMessage())
                    || "用户名或邮箱已存在".equals(ex.getMessage()) ? 409 : 400;
            return ApiResponse.fail(code, ex.getMessage());
        } catch (Exception ex) {
            return ApiResponse.fail(500, "注册失败，请稍后重试");
        }
    }

    /**
     * 用户登录。
     * （由 Curosr 自动生成）
     *
     * @param request 登录请求
     * @param session Session
     * @return 统一响应
     */
    @PostMapping("/login")
    public ApiResponse<UserSessionView> login(@RequestBody LoginRequest request, HttpSession session) {
        try {
            UserSessionView view = authService.login(request, session);
            return ApiResponse.ok("登录成功", view);
        } catch (IllegalArgumentException ex) {
            return ApiResponse.fail(400, ex.getMessage());
        } catch (Exception ex) {
            return ApiResponse.fail(500, "登录失败，请稍后重试");
        }
    }

    /**
     * 退出登录。
     * （由 Curosr 自动生成）
     *
     * @param session Session
     * @return 统一响应
     */
    @PostMapping("/logout")
    public ApiResponse<Void> logout(HttpSession session) {
        authService.logout(session);
        return ApiResponse.ok("已退出登录", null);
    }

    /**
     * 当前登录用户（需登录；由拦截器保护）。
     * （由 Curosr 自动生成）
     *
     * @param session Session
     * @return 统一响应
     */
    @GetMapping("/me")
    public ApiResponse<UserSessionView> me(HttpSession session) {
        return ApiResponse.ok(authService.currentUser(session));
    }
}
