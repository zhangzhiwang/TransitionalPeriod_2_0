package cursor.website.dao.interfaces;

import cursor.website.model.News;

import java.util.List;

/**
 * 新闻数据访问接口。
 * （由 Curosr 自动生成）
 */
public interface NewsDao {

    /**
     * 查询已发布新闻，按发布日期倒序（首页等简单场景）。
     * （由 Curosr 自动生成）
     *
     * @param limit 最大条数，小于等于 0 表示不限制
     * @return 已发布新闻列表
     */
    List<News> listPublished(int limit);

    /**
     * 按分类分页查询已发布新闻（可排除指定 id，例如头条）。
     * （由 Curosr 自动生成）
     *
     * @param category  分类，空表示全部
     * @param excludeId 排除的新闻 id，可为 null
     * @param offset    偏移量
     * @param limit     条数
     * @return 新闻列表
     */
    List<News> listPublishedByCategory(String category, Long excludeId, int offset, int limit);

    /**
     * 统计已发布新闻数量（可按分类、可排除 id）。
     * （由 Curosr 自动生成）
     *
     * @param category  分类，空表示全部
     * @param excludeId 排除的新闻 id，可为 null
     * @return 数量
     */
    long countPublished(String category, Long excludeId);

    /**
     * 查询一条已发布头条；无则返回最新一条已发布新闻。
     * （由 Curosr 自动生成）
     *
     * @param category 分类，空表示全部
     * @return 头条新闻，可能为 null
     */
    News findFeatured(String category);

    /**
     * 按 id 查询已发布新闻。
     * （由 Curosr 自动生成）
     *
     * @param id 新闻 id
     * @return 新闻，不存在或未发布则 null
     */
    News findPublishedById(Long id);

    /**
     * 查询同分类相关阅读。
     * （由 Curosr 自动生成）
     *
     * @param category  分类
     * @param excludeId 排除当前文章
     * @param limit     条数
     * @return 相关新闻
     */
    List<News> listRelated(String category, Long excludeId, int limit);

    /**
     * 列出已发布新闻中出现过的分类（去重）。
     * （由 Curosr 自动生成）
     *
     * @return 分类名称列表
     */
    List<String> listCategories();

    /**
     * 阅读量加一。
     * （由 Curosr 自动生成）
     *
     * @param id 新闻 id
     */
    void increaseViewCount(Long id);
}
