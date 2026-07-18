package cursor.website.dao;

import cursor.website.dao.interfaces.SiteConfigDao;
import cursor.website.mapper.SiteConfigMapper;
import cursor.website.model.SiteConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 站点配置数据访问实现。
 * （由 Curosr 自动生成）
 */
@Repository
@RequiredArgsConstructor
public class SiteConfigDaoImpl implements SiteConfigDao {

    /** MyBatis-Plus Mapper。 */
    private final SiteConfigMapper siteConfigMapper;

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public List<SiteConfig> listAll() {
        return siteConfigMapper.selectList(null);
    }
}
