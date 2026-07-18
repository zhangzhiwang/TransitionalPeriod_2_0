package cursor.mall.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 发送注册邮箱验证码请求体。
 * （由 Curosr 自动生成）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendRegisterCodeRequest {

    /** 接收验证码的邮箱。 */
    private String email;
}
