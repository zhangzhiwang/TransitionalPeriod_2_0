package cursor.mall.controller;

import cursor.mall.common.ApiResponse;
import cursor.mall.model.HomeContent;
import cursor.mall.service.interfaces.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页 JSON API，对应接口文档 GET /api/home。
 * （由 Curosr 自动生成）
 */
@RestController
@RequestMapping("/api")
public class HomeApiController {

    /** 首页业务服务。 */
    private final HomeService homeService;

    /**
     * 构造注入首页服务。
     * （由 Curosr 自动生成）
     *
     * @param homeService 首页服务
     */
    public HomeApiController(HomeService homeService) {
        this.homeService = homeService;
    }

    /**
     * 返回首页聚合 JSON。
     * （由 Curosr 自动生成）
     *
     * @return 统一响应
     */
    @GetMapping("/home")
    public ApiResponse<HomeContent> home() {
        return ApiResponse.ok(homeService.buildHomeContent());
    }
}
