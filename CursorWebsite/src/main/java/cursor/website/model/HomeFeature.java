package cursor.website.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 首页产品亮点实体，对应表 home_feature。
 * （由 Curosr 自动生成）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("home_feature")
public class HomeFeature {

    /** 主键。 */
    @TableId(type = IdType.AUTO)
    private Long id;

    /** 亮点标题。 */
    private String title;

    /** 亮点一句说明。 */
    private String description;

    /** 全宽意象图 URL。 */
    private String imageUrl;

    /** 是否使用深色背景。 */
    private Boolean dark;

    /** 排序，越小越靠前。 */
    private Integer sortOrder;

    /** 状态 draft / published。 */
    private String status;
}
