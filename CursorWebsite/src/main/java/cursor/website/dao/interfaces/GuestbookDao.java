package cursor.website.dao.interfaces;

import cursor.website.model.Guestbook;

import java.util.List;

/**
 * 网站留言数据访问接口。
 * （由 Curosr 自动生成）
 */
public interface GuestbookDao {

    /**
     * 分页查询已审核留言，按创建时间倒序。
     * （由 Curosr 自动生成）
     *
     * @param offset 偏移量
     * @param limit  条数
     * @return 留言列表
     */
    List<Guestbook> listApproved(int offset, int limit);

    /**
     * 统计已审核留言数量。
     * （由 Curosr 自动生成）
     *
     * @return 数量
     */
    long countApproved();

    /**
     * 新增留言。
     * （由 Curosr 自动生成）
     *
     * @param guestbook 留言实体
     * @return 影响行数
     */
    int insert(Guestbook guestbook);
}
