package cursor.website.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import cursor.website.dao.interfaces.NewsDao;
import cursor.website.mapper.NewsMapper;
import cursor.website.model.News;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 新闻数据访问实现。
 * （由 Curosr 自动生成）
 */
@Repository
@RequiredArgsConstructor
public class NewsDaoImpl implements NewsDao {

    /** MyBatis-Plus Mapper。 */
    private final NewsMapper newsMapper;

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public List<News> listPublished(int limit) {
        return listPublishedByCategory(null, null, 0, limit);
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public List<News> listPublishedByCategory(String category, Long excludeId, int offset, int limit) {
        LambdaQueryWrapper<News> wrapper = basePublishedWrapper(category, excludeId)
                .orderByDesc(News::getPublishDate)
                .orderByDesc(News::getId);
        if (limit > 0) {
            wrapper.last("LIMIT " + offset + "," + limit);
        }
        return newsMapper.selectList(wrapper);
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public long countPublished(String category, Long excludeId) {
        return newsMapper.selectCount(basePublishedWrapper(category, excludeId));
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public News findFeatured(String category) {
        LambdaQueryWrapper<News> featuredWrapper = basePublishedWrapper(category, null)
                .eq(News::getFeatured, true)
                .orderByDesc(News::getPublishDate)
                .last("LIMIT 1");
        News featured = newsMapper.selectOne(featuredWrapper);
        if (featured != null) {
            return featured;
        }
        List<News> latest = listPublishedByCategory(category, null, 0, 1);
        return latest.isEmpty() ? null : latest.get(0);
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public News findPublishedById(Long id) {
        if (id == null) {
            return null;
        }
        return newsMapper.selectOne(new LambdaQueryWrapper<News>()
                .eq(News::getId, id)
                .eq(News::getStatus, "published"));
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public List<News> listRelated(String category, Long excludeId, int limit) {
        return listPublishedByCategory(category, excludeId, 0, limit);
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public List<String> listCategories() {
        List<News> list = newsMapper.selectList(new LambdaQueryWrapper<News>()
                .select(News::getCategory)
                .eq(News::getStatus, "published")
                .orderByAsc(News::getCategory));
        Set<String> set = new LinkedHashSet<String>();
        for (News news : list) {
            if (StringUtils.hasText(news.getCategory())) {
                set.add(news.getCategory());
            }
        }
        return new ArrayList<String>(set);
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public void increaseViewCount(Long id) {
        if (id == null) {
            return;
        }
        newsMapper.update(null, new LambdaUpdateWrapper<News>()
                .eq(News::getId, id)
                .setSql("view_count = IFNULL(view_count, 0) + 1"));
    }

    /**
     * 构造已发布新闻的基础查询条件。
     * （由 Curosr 自动生成）
     *
     * @param category  分类
     * @param excludeId 排除 id
     * @return 查询包装器
     */
    private LambdaQueryWrapper<News> basePublishedWrapper(String category, Long excludeId) {
        LambdaQueryWrapper<News> wrapper = new LambdaQueryWrapper<News>()
                .eq(News::getStatus, "published");
        if (StringUtils.hasText(category) && !"all".equalsIgnoreCase(category)) {
            wrapper.eq(News::getCategory, category);
        }
        if (excludeId != null) {
            wrapper.ne(News::getId, excludeId);
        }
        return wrapper;
    }
}
