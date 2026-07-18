package cursor.website.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页聚合数据：Hero 文案、亮点区块、最新新闻。
 * （由 Curosr 自动生成）
 */
@Data
@NoArgsConstructor
public class HomeContent {

    /** 品牌名。 */
    private String brandName;

    /** Hero 主标题。 */
    private String heroHeadline;

    /** Hero 支撑文案。 */
    private String heroSubtitle;

    /** Hero 全宽主视觉 URL。 */
    private String heroImageUrl;

    /** 产品亮点列表。 */
    private List<HomeFeature> features = new ArrayList<HomeFeature>();

    /** 最新动态（通常 3 条）。 */
    private List<News> latestNews = new ArrayList<News>();
}
