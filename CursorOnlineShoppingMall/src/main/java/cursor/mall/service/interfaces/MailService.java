package cursor.mall.service.interfaces;

/**
 * 邮件发送服务接口：注册验证码等。
 * （由 Curosr 自动生成）
 */
public interface MailService {

    /**
     * 同步发送注册邮箱 6 位验证码（便于前端获知是否发送成功）。
     * （由 Curosr 自动生成）
     *
     * @param toEmail 收件邮箱
     * @param code    6 位验证码
     */
    void sendRegisterVerifyCode(String toEmail, String code);
}
