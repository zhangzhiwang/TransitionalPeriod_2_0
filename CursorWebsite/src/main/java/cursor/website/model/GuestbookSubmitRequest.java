package cursor.website.model;

import lombok.Data;

/**
 * 发表留言请求体。
 * （由 Curosr 自动生成）
 */
@Data
public class GuestbookSubmitRequest {

    /** 昵称。 */
    private String nickname;

    /** 邮箱（可选）。 */
    private String email;

    /** 留言内容。 */
    private String content;
}
