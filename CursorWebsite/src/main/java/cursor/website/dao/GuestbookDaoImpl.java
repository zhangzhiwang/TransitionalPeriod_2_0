package cursor.website.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import cursor.website.dao.interfaces.GuestbookDao;
import cursor.website.mapper.GuestbookMapper;
import cursor.website.model.Guestbook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 网站留言数据访问实现。
 * （由 Curosr 自动生成）
 */
@Repository
@RequiredArgsConstructor
public class GuestbookDaoImpl implements GuestbookDao {

    /** MyBatis-Plus Mapper。 */
    private final GuestbookMapper guestbookMapper;

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public List<Guestbook> listApproved(int offset, int limit) {
        LambdaQueryWrapper<Guestbook> wrapper = new LambdaQueryWrapper<Guestbook>()
                .eq(Guestbook::getStatus, "approved")
                .orderByDesc(Guestbook::getCreatedAt)
                .orderByDesc(Guestbook::getId);
        if (limit > 0) {
            wrapper.last("LIMIT " + offset + "," + limit);
        }
        return guestbookMapper.selectList(wrapper);
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public long countApproved() {
        return guestbookMapper.selectCount(new LambdaQueryWrapper<Guestbook>()
                .eq(Guestbook::getStatus, "approved"));
    }

    /**
     * {@inheritDoc}
     * （由 Curosr 自动生成）
     */
    @Override
    public int insert(Guestbook guestbook) {
        return guestbookMapper.insert(guestbook);
    }
}
