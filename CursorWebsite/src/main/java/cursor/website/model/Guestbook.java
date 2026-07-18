package cursor.website.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 网站留言实体，对应表 guestbook。
 * （由 Curosr 自动生成）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("guestbook")
public class Guestbook {

    /** 前台时间展示格式。 */
    private static final DateTimeFormatter DISPLAY_TIME =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /** 主键。 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 昵称。 */
    private String nickname;

    /** 邮箱（可选，前台不公开）。 */
    private String email;

    /** 留言正文。 */
    private String content;

    /** 管理员回复。 */
    private String reply;

    /** 回复时间。 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime replyTime;

    /** 提交 IP。 */
    private String clientIp;

    /** 状态：pending / approved / rejected。 */
    private String status;

    /** 创建时间。 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    /**
     * 创建时间的可读展示（JSP 用）。
     * （由 Curosr 自动生成）
     *
     * @return 格式化后的时间，空则空串
     */
    public String getCreatedAtText() {
        if (createdAt == null) {
            return "";
        }
        return createdAt.format(DISPLAY_TIME);
    }

    /**
     * 回复时间的可读展示（JSP 用）。
     * （由 Curosr 自动生成）
     *
     * @return 格式化后的时间，空则空串
     */
    public String getReplyTimeText() {
        if (replyTime == null) {
            return "";
        }
        return replyTime.format(DISPLAY_TIME);
    }
}
