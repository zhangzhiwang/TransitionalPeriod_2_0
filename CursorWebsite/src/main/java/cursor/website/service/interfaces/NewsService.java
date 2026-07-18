package cursor.website.service.interfaces;

import cursor.website.model.News;
import cursor.website.model.NewsDetailPage;
import cursor.website.model.NewsListPage;

import java.util.List;

/**
 * 新闻业务服务接口。
 * （由 Curosr 自动生成）
 */
public interface NewsService {

    /**
     * 查询已发布新闻，按发布日期倒序（首页等简单场景）。
     * （由 Curosr 自动生成）
     *
     * @param limit 最大条数，小于等于 0 表示不限制
     * @return 已发布新闻列表
     */
    List<News> listPublished(int limit);

    /**
     * 构建新闻列表页数据。
     * （由 Curosr 自动生成）
     *
     * @param category 分类，空或 all 表示全部
     * @param page     页码，从 1 开始
     * @param size     每页条数
     * @return 列表页聚合数据
     */
    NewsListPage buildListPage(String category, int page, int size);

    /**
     * 构建新闻详情页数据，并增加阅读量。
     * （由 Curosr 自动生成）
     *
     * @param id 新闻 id
     * @return 详情页数据，不存在则 null
     */
    NewsDetailPage buildDetailPage(Long id);
}
