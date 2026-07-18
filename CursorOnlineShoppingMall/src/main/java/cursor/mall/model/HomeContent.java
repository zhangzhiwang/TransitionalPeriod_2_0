package cursor.mall.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 首页聚合数据：轮播、推荐商品、分类预览块。
 * （由 Curosr 自动生成）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeContent {

    /** 商城显示名称（顶栏）。 */
    private String mallName;

    /** 轮播图列表。 */
    private List<Banner> banners;

    /** 推荐商品列表。 */
    private List<ProductBrief> recommendProducts;

    /** 分类及每类最多 3 个商品。 */
    private List<CategoryBlock> categoryBlocks;
}
