package cursor.website.controller;

import cursor.website.common.ApiResponse;
import cursor.website.model.GuestbookListPage;
import cursor.website.model.GuestbookSubmitRequest;
import cursor.website.service.interfaces.GuestbookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 网站留言 REST API。
 * （由 Curosr 自动生成）
 */
@RestController
@RequestMapping("/api/guestbook")
@RequiredArgsConstructor
public class GuestbookApiController {

    /** 留言业务服务。 */
    private final GuestbookService guestbookService;

    /**
     * 分页获取已审核留言。
     * （由 Curosr 自动生成）
     *
     * @param page 页码
     * @param size 每页条数
     * @return 统一 JSON 响应
     */
    @GetMapping
    public ApiResponse<GuestbookListPage> list(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return ApiResponse.ok(guestbookService.buildListPage(page, size));
    }

    /**
     * 提交留言（待审核）。
     * （由 Curosr 自动生成）
     *
     * @param request 提交内容
     * @param httpRequest HTTP 请求（取 IP）
     * @return 统一 JSON 响应
     */
    @PostMapping
    public ApiResponse<Void> submit(@RequestBody GuestbookSubmitRequest request,
                                    HttpServletRequest httpRequest) {
        try {
            guestbookService.submit(request, resolveClientIp(httpRequest));
            return new ApiResponse<Void>(0, "已提交，审核后公开", null);
        } catch (IllegalArgumentException ex) {
            return new ApiResponse<Void>(400, ex.getMessage(), null);
        } catch (IllegalStateException ex) {
            return new ApiResponse<Void>(429, ex.getMessage(), null);
        }
    }

    /**
     * 解析客户端 IP。
     * （由 Curosr 自动生成）
     *
     * @param request HTTP 请求
     * @return IP 字符串
     */
    private String resolveClientIp(HttpServletRequest request) {
        String forwarded = request.getHeader("X-Forwarded-For");
        if (forwarded != null && forwarded.length() > 0) {
            int comma = forwarded.indexOf(',');
            return comma > 0 ? forwarded.substring(0, comma).trim() : forwarded.trim();
        }
        return request.getRemoteAddr();
    }
}
