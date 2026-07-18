package cursor.website.config;

import cursor.website.model.GuestbookListPage;
import cursor.website.service.interfaces.GuestbookService;
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
 * 网站留言 JSP 直访过滤器：渲染前注入已审核列表数据。
 * （由 Curosr 自动生成）
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 21)
@RequiredArgsConstructor
public class GuestbookPageFilter extends OncePerRequestFilter {

    /** 留言业务服务。 */
    private final GuestbookService guestbookService;

    /**
     * 对 /messages.jsp 注入 guestbookPage 后放行。
     * （由 Curosr 自动生成）
     *
     * @param request     请求
     * @param response    响应
     * @param filterChain 过滤器链
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        if ("/messages.jsp".equals(request.getServletPath())) {
            int page = parsePositiveInt(request.getParameter("page"), 1);
            int size = parsePositiveInt(request.getParameter("size"), 10);
            GuestbookListPage guestbookPage = guestbookService.buildListPage(page, size);
            request.setAttribute("guestbookPage", guestbookPage);
            request.setAttribute("currentNav", "messages");
        }
        filterChain.doFilter(request, response);
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
