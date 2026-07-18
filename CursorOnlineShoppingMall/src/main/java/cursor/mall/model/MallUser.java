package cursor.mall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 商城用户实体，对应表 mall_user。
 * （由 Curosr 自动生成）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("mall_user")
public class MallUser {

    /** 主键。 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 登录用户名，唯一。 */
    private String username;

    /** 密码密文（SHA-256 等），禁止明文。 */
    @TableField("password_hash")
    private String passwordHash;

    /** 注册邮箱。 */
    private String email;

    /** 昵称（可来自微信授权）。 */
    private String nickname;

    /** 头像 URL（可来自微信授权）。 */
    @TableField("avatar_url")
    private String avatarUrl;

    /** 微信 openid，可空。 */
    @TableField("wechat_openid")
    private String wechatOpenid;

    /** 状态：1 正常，0 禁用。 */
    private Integer status;

    /** 创建时间。 */
    @TableField("created_at")
    private LocalDateTime createdAt;

    /** 更新时间。 */
    @TableField("updated_at")
    private LocalDateTime updatedAt;
}
