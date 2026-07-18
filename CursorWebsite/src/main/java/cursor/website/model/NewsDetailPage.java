package cursor.website.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻详情页聚合数据：正文与相关阅读。
 * （由 Curosr 自动生成）
 */
@Data
public class NewsDetailPage {

    /** 当前文章。 */
    private News article;

    /** 相关阅读列表。 */
    private List<News> related = new ArrayList<News>();
}
