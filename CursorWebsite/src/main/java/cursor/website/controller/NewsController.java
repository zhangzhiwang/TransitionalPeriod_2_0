package cursor.website.controller;

import cursor.website.model.NewsDetailPage;
import cursor.website.model.NewsListPage;
import cursor.website.service.interfaces.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 新闻中心页面控制器：列表页与详情页。
 * （由 Curosr 自动生成）
 */
@Controller
@RequiredArgsConstructor
public class NewsController {

    /** 新闻业务服务。 */
    private final NewsService newsService;

    /**
     * 新闻列表页（优雅 URL）。
     * 说明：直接访问 /news.jsp 时由 NewsPageFilter 注入数据，不经过本方法。
     * （由 Curosr 自动生成）
     *
     * @param category 分类，可选
     * @param page     页码，默认 1
     * @param size     每页条数，默认 6
     * @param model    视图模型
     * @return 转发到列表 JSP
     */
    @GetMapping("/news")
    public String list(@RequestParam(value = "category", required = false) String category,
                       @RequestParam(value = "page", defaultValue = "1") int page,
                       @RequestParam(value = "size", defaultValue = "6") int size,
                       Model model) {
        NewsListPage newsPage = newsService.buildListPage(category, page, size);
        model.addAttribute("newsPage", newsPage);
        model.addAttribute("currentNav", "news");
        return "forward:/WEB-INF/jsp/news.jsp";
    }

    /**
     * 新闻详情页（优雅 URL）。
     * （由 Curosr 自动生成）
     *
     * @param id    新闻 id
     * @param model 视图模型
     * @return 转发到详情 JSP；不存在则回列表
     */
    @GetMapping("/news/detail")
    public String detail(@RequestParam("id") Long id, Model model) {
        NewsDetailPage detailPage = newsService.buildDetailPage(id);
        if (detailPage == null) {
            return "redirect:/news.jsp";
        }
        model.addAttribute("detailPage", detailPage);
        model.addAttribute("currentNav", "news");
        return "forward:/WEB-INF/jsp/news-detail.jsp";
    }
}
