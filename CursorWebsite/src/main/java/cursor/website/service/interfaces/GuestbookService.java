package cursor.website.service.interfaces;

import cursor.website.model.GuestbookListPage;
import cursor.website.model.GuestbookSubmitRequest;

/**
 * 网站留言业务服务接口。
 * （由 Curosr 自动生成）
 */
public interface GuestbookService {

    /**
     * 构建已审核留言列表页数据。
     * （由 Curosr 自动生成）
     *
     * @param page 页码，从 1 开始
     * @param size 每页条数
     * @return 列表聚合数据
     */
    GuestbookListPage buildListPage(int page, int size);

    /**
     * 提交留言（写入待审核）。
     * （由 Curosr 自动生成）
     *
     * @param request  提交内容
     * @param clientIp 客户端 IP
     * @throws IllegalArgumentException 校验失败
     * @throws IllegalStateException    触发限流等业务限制
     */
    void submit(GuestbookSubmitRequest request, String clientIp);
}
