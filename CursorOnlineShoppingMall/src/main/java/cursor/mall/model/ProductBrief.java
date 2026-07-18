package cursor.mall.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 首页/列表用的商品简要信息。
 * （由 Curosr 自动生成）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductBrief {

    /** 商品主键。 */
    private Long id;

    /** 商品名称。 */
    private String name;

    /** 商品主图。 */
    private String imageUrl;

    /** 售价。 */
    private BigDecimal price;

    /** 库存数量。 */
    private Integer stock;
}
