package cursor.mall.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import cursor.mall.dao.interfaces.MallUserDao;
import cursor.mall.mapper.MallUserMapper;
import cursor.mall.model.MallUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 商城用户数据访问实现：真实读写 mall_user 表。
 * （由 Curosr 自动生成）
 */
@Repository
@RequiredArgsConstructor
public class MallUserDaoImpl implements MallUserDao {

    /** MyBatis-Plus Mapper。 */
    private final MallUserMapper mallUserMapper;

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public MallUser findByUsername(String username) {
        return mallUserMapper.selectOne(new LambdaQueryWrapper<MallUser>()
                .eq(MallUser::getUsername, username)
                .last("LIMIT 1"));
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public MallUser findByEmail(String email) {
        return mallUserMapper.selectOne(new LambdaQueryWrapper<MallUser>()
                .eq(MallUser::getEmail, email)
                .last("LIMIT 1"));
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public MallUser findById(Long id) {
        return mallUserMapper.selectById(id);
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public int insert(MallUser user) {
        return mallUserMapper.insert(user);
    }
}
