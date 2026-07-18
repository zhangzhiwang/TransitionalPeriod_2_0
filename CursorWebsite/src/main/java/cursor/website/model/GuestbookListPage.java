package cursor.website.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 网站留言列表页聚合数据。
 * （由 Curosr 自动生成）
 */
@Data
public class GuestbookListPage {

    /** 已审核留言列表（不含邮箱）。 */
    private List<Guestbook> items = new ArrayList<Guestbook>();

    /** 当前页码，从 1 开始。 */
    private int page;

    /** 每页条数。 */
    private int size;

    /** 是否还有下一页。 */
    private boolean hasMore;
}
