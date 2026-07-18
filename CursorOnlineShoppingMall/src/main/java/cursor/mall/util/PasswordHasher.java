package cursor.mall.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 密码哈希工具：使用 SHA-256 十六进制小写，禁止明文落库。
 * （由 Curosr 自动生成）
 */
public final class PasswordHasher {

    /**
     * 私有构造，禁止实例化。
     * （由 Curosr 自动生成）
     */
    private PasswordHasher() {
    }

    /**
     * 对明文密码做 SHA-256 摘要。
     * （由 Curosr 自动生成）
     *
     * @param rawPassword 明文密码
     * @return 64 位十六进制小写字符串
     */
    public static String sha256Hex(String rawPassword) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(rawPassword.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(hash.length * 2);
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("当前 JDK 不支持 SHA-256", e);
        }
    }

    /**
     * 恒定时间比较两个哈希，降低时序攻击风险。
     * （由 Curosr 自动生成）
     *
     * @param left  左侧哈希
     * @param right 右侧哈希
     * @return 相等返回 true
     */
    public static boolean matches(String left, String right) {
        if (left == null || right == null) {
            return false;
        }
        if (left.length() != right.length()) {
            return false;
        }
        int result = 0;
        for (int i = 0; i < left.length(); i++) {
            result |= left.charAt(i) ^ right.charAt(i);
        }
        return result == 0;
    }
}
