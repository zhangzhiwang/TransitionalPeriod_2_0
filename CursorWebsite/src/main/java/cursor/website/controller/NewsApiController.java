package cursor.website.controller;

import cursor.website.common.ApiResponse;
import cursor.website.model.News;
import cursor.website.model.NewsDetailPage;
import cursor.website.model.NewsListPage;
import cursor.website.service.interfaces.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 新闻中心 REST API。
 * （由 Curosr 自动生成）
 */
@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsApiController {

    /** 新闻业务服务。 */
    private final NewsService newsService;

    /**
     * 分页获取新闻列表（支持分类）。
     * （由 Curosr 自动生成）
     *
     * @param category 分类，可选
     * @param page     页码
     * @param size     每页条数
     * @return 统一 JSON 响应
     */
    @GetMapping
    public ApiResponse<NewsListPage> list(
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "6") int size) {
        return ApiResponse.ok(newsService.buildListPage(category, page, size));
    }

    /**
     * 获取新闻详情（含相关阅读，并累计阅读量）。
     * （由 Curosr 自动生成）
     *
     * @param id 新闻 id
     * @return 统一 JSON 响应
     */
    @GetMapping("/{id}")
    public ApiResponse<NewsDetailPage> detail(@PathVariable("id") Long id) {
        NewsDetailPage page = newsService.buildDetailPage(id);
        if (page == null) {
            return new ApiResponse<NewsDetailPage>(404, "news not found", null);
        }
        return ApiResponse.ok(page);
    }

    /**
     * 兼容首页：仅返回摘要列表。
     * （由 Curosr 自动生成）
     *
     * @param limit 条数
     * @return 新闻摘要列表
     */
    @GetMapping("/latest")
    public ApiResponse<java.util.List<News>> latest(
            @RequestParam(value = "limit", defaultValue = "3") int limit) {
        return ApiResponse.ok(newsService.listPublished(limit));
    }
}
