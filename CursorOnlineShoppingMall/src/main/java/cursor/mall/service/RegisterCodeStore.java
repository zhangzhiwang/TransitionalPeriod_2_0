package cursor.mall.service;

import cursor.mall.dao.interfaces.MallUserDao;
import cursor.mall.service.interfaces.MailService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册邮箱验证码存储器：内存缓存、过期清理、发送频率限制。
 * （由 Curosr 自动生成）
 */
@Service
public class RegisterCodeStore {

    /** 验证码有效期（毫秒）：5 分钟。 */
    private static final long EXPIRE_MS = 5 * 60 * 1000L;

    /** 同一邮箱最短重发间隔（毫秒）：60 秒。 */
    private static final long RESEND_INTERVAL_MS = 60 * 1000L;

    /** 安全随机数。 */
    private final SecureRandom secureRandom = new SecureRandom();

    /** 邮箱 → 验证码记录。 */
    private final ConcurrentHashMap<String, CodeRecord> store = new ConcurrentHashMap<String, CodeRecord>();

    /** 用户 Dao（发送前检查邮箱是否已注册）。 */
    private final MallUserDao mallUserDao;

    /** 邮件服务。 */
    private final MailService mailService;

    /**
     * 构造注入依赖。
     * （由 Curosr 自动生成）
     *
     * @param mallUserDao 用户 Dao
     * @param mailService 邮件服务
     */
    public RegisterCodeStore(MallUserDao mallUserDao, MailService mailService) {
        this.mallUserDao = mallUserDao;
        this.mailService = mailService;
    }

    /**
     * 生成并发送 6 位验证码到指定邮箱。
     * （由 Curosr 自动生成）
     *
     * @param email 邮箱
     */
    public void sendCode(String email) {
        String key = normalizeEmail(email);
        if (!StringUtils.hasText(key)) {
            throw new IllegalArgumentException("请填写邮箱");
        }
        if (mallUserDao.findByEmail(key) != null) {
            throw new IllegalArgumentException("邮箱已被注册");
        }
        cleanupExpired();
        CodeRecord existing = store.get(key);
        long now = System.currentTimeMillis();
        if (existing != null && now - existing.getSentAt() < RESEND_INTERVAL_MS) {
            long waitSec = (RESEND_INTERVAL_MS - (now - existing.getSentAt()) + 999) / 1000;
            throw new IllegalArgumentException("发送过于频繁，请 " + waitSec + " 秒后再试");
        }
        String code = randomSixDigits();
        mailService.sendRegisterVerifyCode(key, code);
        store.put(key, new CodeRecord(code, now, now + EXPIRE_MS));
    }

    /**
     * 校验验证码：匹配且未过期则消费（一次性）。
     * （由 Curosr 自动生成）
     *
     * @param email 邮箱
     * @param code  用户输入的验证码
     */
    public void consumeValidCode(String email, String code) {
        String key = normalizeEmail(email);
        String input = code == null ? "" : code.trim();
        if (!StringUtils.hasText(key)) {
            throw new IllegalArgumentException("请填写邮箱");
        }
        if (!input.matches("^\\d{6}$")) {
            throw new IllegalArgumentException("请输入 6 位数字验证码");
        }
        cleanupExpired();
        CodeRecord record = store.get(key);
        if (record == null || System.currentTimeMillis() > record.getExpireAt()) {
            store.remove(key);
            throw new IllegalArgumentException("验证码无效或已过期，请重新获取");
        }
        if (!record.getCode().equals(input)) {
            throw new IllegalArgumentException("验证码错误");
        }
        store.remove(key);
    }

    /**
     * 生成 6 位数字验证码（含前导 0）。
     * （由 Curosr 自动生成）
     *
     * @return 验证码字符串
     */
    private String randomSixDigits() {
        int n = secureRandom.nextInt(1_000_000);
        return String.format("%06d", n);
    }

    /**
     * 邮箱规范化：去空白并转小写。
     * （由 Curosr 自动生成）
     *
     * @param email 原邮箱
     * @return 规范化结果
     */
    private String normalizeEmail(String email) {
        if (email == null) {
            return null;
        }
        String trimmed = email.trim();
        return trimmed.isEmpty() ? null : trimmed.toLowerCase();
    }

    /**
     * 清理过期验证码。
     * （由 Curosr 自动生成）
     */
    private void cleanupExpired() {
        long now = System.currentTimeMillis();
        Iterator<Map.Entry<String, CodeRecord>> it = store.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, CodeRecord> entry = it.next();
            if (now > entry.getValue().getExpireAt()) {
                it.remove();
            }
        }
    }

    /**
     * 单条验证码记录。
     * （由 Curosr 自动生成）
     */
    private static final class CodeRecord {

        /** 验证码。 */
        private final String code;

        /** 发送时间戳。 */
        private final long sentAt;

        /** 过期时间戳。 */
        private final long expireAt;

        /**
         * 构造验证码记录。
         * （由 Curosr 自动生成）
         *
         * @param code     验证码
         * @param sentAt   发送时间
         * @param expireAt 过期时间
         */
        private CodeRecord(String code, long sentAt, long expireAt) {
            this.code = code;
            this.sentAt = sentAt;
            this.expireAt = expireAt;
        }

        /**
         * 获取验证码。
         * （由 Curosr 自动生成）
         *
         * @return 验证码
         */
        private String getCode() {
            return code;
        }

        /**
         * 获取发送时间。
         * （由 Curosr 自动生成）
         *
         * @return 毫秒时间戳
         */
        private long getSentAt() {
            return sentAt;
        }

        /**
         * 获取过期时间。
         * （由 Curosr 自动生成）
         *
         * @return 毫秒时间戳
         */
        private long getExpireAt() {
            return expireAt;
        }
    }
}
