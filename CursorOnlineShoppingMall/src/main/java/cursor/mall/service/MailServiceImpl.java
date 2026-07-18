package cursor.mall.service;

import cursor.mall.service.interfaces.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 邮件发送实现：注册验证码；未启用 SMTP 时打日志仍视为可测通。
 * （由 Curosr 自动生成）
 */
@Service
public class MailServiceImpl implements MailService {

    /** 日志。 */
    private static final Logger log = LoggerFactory.getLogger(MailServiceImpl.class);

    /** 是否真正发送邮件。 */
    private final boolean mailEnabled;

    /** 发件人地址。 */
    private final String fromAddress;

    /** Spring 邮件发送器，未配置 host 时可能为 null。 */
    private final JavaMailSender mailSender;

    /**
     * 构造注入邮件配置与可选 MailSender。
     * （由 Curosr 自动生成）
     *
     * @param mailEnabled 是否启用真实发送
     * @param fromAddress 发件人
     * @param mailSender  邮件发送器（可空）
     */
    public MailServiceImpl(
            @Value("${mall.mail.enabled:false}") boolean mailEnabled,
            @Value("${spring.mail.username:}") String fromAddress,
            @Autowired(required = false) JavaMailSender mailSender) {
        this.mailEnabled = mailEnabled;
        this.fromAddress = fromAddress;
        this.mailSender = mailSender;
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public void sendRegisterVerifyCode(String toEmail, String code) {
        String subject = "【CursorOnlineShoppingMall】注册验证码";
        String text = "你好！\n\n"
                + "你的注册验证码是：" + code + "\n"
                + "有效期 5 分钟，请勿泄露给他人。\n";
        if (!mailEnabled || mailSender == null || !StringUtils.hasText(fromAddress)) {
            log.info("注册验证码邮件（未启用 SMTP，仅日志）：to={}, code={}", toEmail, code);
            return;
        }
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromAddress);
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(text);
            mailSender.send(message);
            log.info("注册验证码邮件已发送：to={}", toEmail);
        } catch (Exception ex) {
            log.warn("注册验证码邮件发送失败：to={}, err={}", toEmail, ex.getMessage());
            throw new IllegalStateException("验证码邮件发送失败，请稍后重试");
        }
    }
}
