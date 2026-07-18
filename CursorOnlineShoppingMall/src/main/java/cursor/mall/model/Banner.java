package cursor.mall.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 首页轮播图条目。
 * （由 Curosr 自动生成）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Banner {

    /** 轮播主键。 */
    private Long id;

    /** 图片地址。 */
    private String imageUrl;

    /** 点击跳转链接。 */
    private String linkUrl;

    /** 排序，越小越靠前。 */
    private Integer sort;
}
