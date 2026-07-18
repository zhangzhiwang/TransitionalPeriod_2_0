package cursor.mall.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录请求体。
 * （由 Curosr 自动生成）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {

    /** 用户名。 */
    private String username;

    /** 密码（明文入参，服务端加密比对）。 */
    private String password;
}
