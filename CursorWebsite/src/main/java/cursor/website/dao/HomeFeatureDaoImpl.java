package cursor.website.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import cursor.website.dao.interfaces.HomeFeatureDao;
import cursor.website.mapper.HomeFeatureMapper;
import cursor.website.model.HomeFeature;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 首页亮点数据访问实现。
 * （由 Curosr 自动生成）
 */
@Repository
@RequiredArgsConstructor
public class HomeFeatureDaoImpl implements HomeFeatureDao {

    /** MyBatis-Plus Mapper。 */
    private final HomeFeatureMapper homeFeatureMapper;

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public List<HomeFeature> listPublishedOrdered() {
        return homeFeatureMapper.selectList(
                new LambdaQueryWrapper<HomeFeature>()
                        .eq(HomeFeature::getStatus, "published")
                        .orderByAsc(HomeFeature::getSortOrder));
    }
}
