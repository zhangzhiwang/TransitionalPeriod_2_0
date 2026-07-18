package cursor.website.controller;

import cursor.website.common.ApiResponse;
import cursor.website.model.HomeContent;
import cursor.website.service.interfaces.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页 REST API。
 * （由 Curosr 自动生成）
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HomeApiController {

    /** 首页业务服务。 */
    private final HomeService homeService;

    /**
     * 获取首页聚合数据。
     * （由 Curosr 自动生成）
     *
     * @return 统一 JSON 响应
     */
    @GetMapping("/home")
    public ApiResponse<HomeContent> home() {
        return ApiResponse.ok(homeService.buildHomeContent());
    }
}
