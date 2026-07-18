package cursor.mall.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 首页分类预览块：分类标题 + 最多 3 个商品。
 * （由 Curosr 自动生成）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryBlock {

    /** 分类主键。 */
    private Long categoryId;

    /** 分类名称。 */
    private String categoryName;

    /** 该分类下预览商品（≤3）。 */
    private List<ProductBrief> products;
}
