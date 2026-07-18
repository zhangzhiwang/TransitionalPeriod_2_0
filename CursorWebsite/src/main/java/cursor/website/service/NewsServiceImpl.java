package cursor.website.service;

import cursor.website.dao.interfaces.NewsDao;
import cursor.website.model.News;
import cursor.website.model.NewsDetailPage;
import cursor.website.model.NewsListPage;
import cursor.website.service.interfaces.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 新闻业务服务实现。
 * （由 Curosr 自动生成）
 */
@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    /** 默认分类 Tab（与设计图一致，库中无数据时的兜底）。 */
    private static final List<String> DEFAULT_CATEGORIES =
            Arrays.asList("公司动态", "产品发布", "行业洞察");

    /** 新闻 Dao。 */
    private final NewsDao newsDao;

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public List<News> listPublished(int limit) {
        return newsDao.listPublished(limit);
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public NewsListPage buildListPage(String category, int page, int size) {
        if (page < 1) {
            page = 1;
        }
        if (size < 1) {
            size = 6;
        }
        String normalized = normalizeCategory(category);
        News featured = newsDao.findFeatured(normalized);
        Long excludeId = featured == null ? null : featured.getId();
        int offset = (page - 1) * size;
        List<News> items = newsDao.listPublishedByCategory(normalized, excludeId, offset, size);
        long total = newsDao.countPublished(normalized, excludeId);

        NewsListPage result = new NewsListPage();
        result.setCategory(StringUtils.hasText(normalized) ? normalized : "all");
        result.setCategories(resolveCategories());
        result.setFeatured(page == 1 ? featured : null);
        result.setItems(items);
        result.setPage(page);
        result.setSize(size);
        result.setHasMore(offset + items.size() < total);
        return result;
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    @Transactional
    public NewsDetailPage buildDetailPage(Long id) {
        News article = newsDao.findPublishedById(id);
        if (article == null) {
            return null;
        }
        newsDao.increaseViewCount(id);
        article.setViewCount((article.getViewCount() == null ? 0 : article.getViewCount()) + 1);

        NewsDetailPage page = new NewsDetailPage();
        page.setArticle(article);
        page.setRelated(newsDao.listRelated(article.getCategory(), article.getId(), 4));
        return page;
    }

    /**
     * 规范化分类参数。
     * （由 Curosr 自动生成）
     *
     * @param category 原始分类
     * @return 规范化后的分类，全部时返回 null
     */
    private String normalizeCategory(String category) {
        if (!StringUtils.hasText(category) || "all".equalsIgnoreCase(category.trim())) {
            return null;
        }
        return category.trim();
    }

    /**
     * 解析分类 Tab：优先库中分类，否则使用设计图默认分类。
     * （由 Curosr 自动生成）
     *
     * @return 分类列表
     */
    private List<String> resolveCategories() {
        List<String> fromDb = newsDao.listCategories();
        if (fromDb == null || fromDb.isEmpty()) {
            return DEFAULT_CATEGORIES;
        }
        return fromDb;
    }
}
