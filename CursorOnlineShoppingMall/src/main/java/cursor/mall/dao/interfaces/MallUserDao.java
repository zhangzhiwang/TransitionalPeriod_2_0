package cursor.mall.dao.interfaces;

import cursor.mall.model.MallUser;

/**
 * 商城用户数据访问接口。
 * （由 Curosr 自动生成）
 */
public interface MallUserDao {

    /**
     * 按用户名查询用户。
     * （由 Curosr 自动生成）
     *
     * @param username 用户名
     * @return 用户实体，不存在则 null
     */
    MallUser findByUsername(String username);

    /**
     * 按邮箱查询用户。
     * （由 Curosr 自动生成）
     *
     * @param email 邮箱
     * @return 用户实体，不存在则 null
     */
    MallUser findByEmail(String email);

    /**
     * 按主键查询用户。
     * （由 Curosr 自动生成）
     *
     * @param id 用户 ID
     * @return 用户实体，不存在则 null
     */
    MallUser findById(Long id);

    /**
     * 插入新用户（真实写库）。
     * （由 Curosr 自动生成）
     *
     * @param user 用户实体
     * @return 影响行数
     */
    int insert(MallUser user);
}
