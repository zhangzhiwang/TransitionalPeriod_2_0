package cursor.mall.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录后返回给前端的用户视图（不含密码）。
 * （由 Curosr 自动生成）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSessionView {

    /** 用户 ID。 */
    private Long userId;

    /** 登录用户名。 */
    private String username;

    /** 昵称。 */
    private String nickname;

    /** 头像 URL。 */
    private String avatarUrl;

    /** 是否已登录。 */
    private boolean loggedIn;
}
