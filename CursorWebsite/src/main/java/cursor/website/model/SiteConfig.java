package cursor.website.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 站点键值配置实体，对应表 site_config。
 * （由 Curosr 自动生成）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("site_config")
public class SiteConfig {

    /** 主键。 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 配置键。 */
    private String configKey;

    /** 配置值。 */
    private String configValue;
}
