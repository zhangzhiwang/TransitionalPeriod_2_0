package cursor.website.controller;

import cursor.website.model.GuestbookListPage;
import cursor.website.service.interfaces.GuestbookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 网站留言页面控制器。
 * （由 Curosr 自动生成）
 */
@Controller
@RequiredArgsConstructor
public class GuestbookController {

    /** 留言业务服务。 */
    private final GuestbookService guestbookService;

    /**
     * 留言板页面（优雅 URL）。
     * （由 Curosr 自动生成）
     *
     * @param page  页码
     * @param size  每页条数
     * @param model 视图模型
     * @return 转发到列表 JSP
     */
    @GetMapping("/messages")
    public String page(@RequestParam(value = "page", defaultValue = "1") int page,
                       @RequestParam(value = "size", defaultValue = "10") int size,
                       Model model) {
        GuestbookListPage guestbookPage = guestbookService.buildListPage(page, size);
        model.addAttribute("guestbookPage", guestbookPage);
        model.addAttribute("currentNav", "messages");
        return "forward:/WEB-INF/jsp/messages.jsp";
    }
}
