package cursor.website.dao.interfaces;

import cursor.website.model.HomeFeature;

import java.util.List;

/**
 * 首页亮点数据访问接口。
 * （由 Curosr 自动生成）
 */
public interface HomeFeatureDao {

    /**
     * 查询已发布亮点，按 sortOrder 升序。
     * （由 Curosr 自动生成）
     *
     * @return 亮点列表
     */
    List<HomeFeature> listPublishedOrdered();
}
