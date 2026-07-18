package cursor.mall.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 注册请求体（含 6 位邮箱验证码）。
 * （由 Curosr 自动生成）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    /** 用户名。 */
    private String username;

    /** 密码。 */
    private String password;

    /** 确认密码。 */
    private String confirmPassword;

    /** 注册邮箱（用于接收验证码）。 */
    private String email;

    /** 邮箱 6 位验证码。 */
    private String verifyCode;
}
