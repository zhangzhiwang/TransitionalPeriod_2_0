package cursor.website.service;

import cursor.website.dao.interfaces.HomeFeatureDao;
import cursor.website.dao.interfaces.SiteConfigDao;
import cursor.website.model.HomeContent;
import cursor.website.model.HomeFeature;
import cursor.website.model.SiteConfig;
import cursor.website.service.interfaces.HomeService;
import cursor.website.service.interfaces.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页业务服务实现：组装 Hero、亮点与最新新闻。
 * （由 Curosr 自动生成）
 */
@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    /** 站点配置 Dao。 */
    private final SiteConfigDao siteConfigDao;

    /** 首页亮点 Dao。 */
    private final HomeFeatureDao homeFeatureDao;

    /** 新闻服务。 */
    private final NewsService newsService;

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public HomeContent buildHomeContent() {
        Map<String, String> config = loadConfigMap();
        HomeContent content = new HomeContent();
        content.setBrandName(configOrDefault(config, "home.brandName", "曜岩智造"));
        content.setHeroHeadline(configOrDefault(config, "home.heroHeadline", "精密制造，定义下一程。"));
        content.setHeroSubtitle(configOrDefault(config, "home.heroSubtitle",
                "以工业软件与智能装备，把产线效率做得可见、可控、可进化。"));
        content.setHeroImageUrl(configOrDefault(config, "home.heroImageUrl",
                "https://images.unsplash.com/photo-1565043666747-69f6646db940?auto=format&fit=crop&w=2000&q=80"));

        List<HomeFeature> features = homeFeatureDao.listPublishedOrdered();
        content.setFeatures(features);
        content.setLatestNews(newsService.listPublished(3));
        return content;
    }

    /**
     * 加载全部站点配置为 Map。
     * （由 Curosr 自动生成）
     *
     * @return 配置键值 Map
     */
    private Map<String, String> loadConfigMap() {
        List<SiteConfig> list = siteConfigDao.listAll();
        Map<String, String> map = new HashMap<String, String>();
        for (SiteConfig item : list) {
            map.put(item.getConfigKey(), item.getConfigValue());
        }
        return map;
    }

    /**
     * 取配置值，空则返回默认值。
     * （由 Curosr 自动生成）
     *
     * @param config       配置 Map
     * @param key          键
     * @param defaultValue 默认值
     * @return 最终文案
     */
    private String configOrDefault(Map<String, String> config, String key, String defaultValue) {
        String value = config.get(key);
        if (!StringUtils.hasText(value)) {
            return defaultValue;
        }
        return value;
    }
}
