package cursor.website.config;

import cursor.website.model.NewsDetailPage;
import cursor.website.model.NewsListPage;
import cursor.website.service.interfaces.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 新闻 JSP 直访过滤器：Tomcat 对 *.jsp 不会进入 Spring Controller，
 * 因此在渲染前注入列表/详情数据，保证「新闻中心」一定访问后台。
 * （由 Curosr 自动生成）
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 20)
@RequiredArgsConstructor
public class NewsPageFilter extends OncePerRequestFilter {

    /** 新闻业务服务。 */
    private final NewsService newsService;

    /**
     * 对 /news.jsp、/news-detail.jsp 注入 request 属性后放行。
     * （由 Curosr 自动生成）
     *
     * @param request     请求
     * @param response    响应
     * @param filterChain 过滤器链
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String path = request.getServletPath();
        if ("/news.jsp".equals(path)) {
            bindListPage(request);
        } else if ("/news-detail.jsp".equals(path)) {
            if (!bindDetailPage(request, response)) {
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    /**
     * 绑定新闻列表页数据。
     * （由 Curosr 自动生成）
     *
     * @param request 请求
     */
    private void bindListPage(HttpServletRequest request) {
        String category = request.getParameter("category");
        int page = parsePositiveInt(request.getParameter("page"), 1);
        int size = parsePositiveInt(request.getParameter("size"), 6);
        NewsListPage newsPage = newsService.buildListPage(category, page, size);
        request.setAttribute("newsPage", newsPage);
        request.setAttribute("currentNav", "news");
    }

    /**
     * 绑定新闻详情页数据；缺少或无效 id 时重定向列表。
     * （由 Curosr 自动生成）
     *
     * @param request  请求
     * @param response 响应
     * @return true 继续渲染；false 已重定向
     */
    private boolean bindDetailPage(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String idText = request.getParameter("id");
        if (!StringUtils.hasText(idText)) {
            response.sendRedirect(request.getContextPath() + "/news");
            return false;
        }
        Long id;
        try {
            id = Long.valueOf(idText.trim());
        } catch (NumberFormatException ex) {
            response.sendRedirect(request.getContextPath() + "/news");
            return false;
        }
        NewsDetailPage detailPage = newsService.buildDetailPage(id);
        if (detailPage == null) {
            response.sendRedirect(request.getContextPath() + "/news");
            return false;
        }
        request.setAttribute("detailPage", detailPage);
        request.setAttribute("currentNav", "news");
        return true;
    }

    /**
     * 解析正整数参数。
     * （由 Curosr 自动生成）
     *
     * @param raw          原始字符串
     * @param defaultValue 默认值
     * @return 解析结果
     */
    private int parsePositiveInt(String raw, int defaultValue) {
        if (!StringUtils.hasText(raw)) {
            return defaultValue;
        }
        try {
            int value = Integer.parseInt(raw.trim());
            return value > 0 ? value : defaultValue;
        } catch (NumberFormatException ex) {
            return defaultValue;
        }
    }
}
