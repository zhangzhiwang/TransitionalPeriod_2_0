package cursor.mall.service;

import cursor.mall.model.Banner;
import cursor.mall.model.CategoryBlock;
import cursor.mall.model.HomeContent;
import cursor.mall.model.ProductBrief;
import cursor.mall.service.interfaces.HomeService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 首页业务实现：现阶段返回写死数据，便于先看页面效果。
 * （由 Curosr 自动生成）
 */
@Service
public class HomeServiceImpl implements HomeService {

    /**
     * 组装首页写死演示数据。
     * （由 Curosr 自动生成）
     *
     * @return 首页内容
     */
    @Override
    public HomeContent buildHomeContent() {
        HomeContent home = new HomeContent();
        home.setMallName("京东风格商城");
        home.setBanners(buildBanners());
        home.setRecommendProducts(buildRecommendProducts());
        home.setCategoryBlocks(buildCategoryBlocks());
        return home;
    }

    /**
     * 构造轮播图写死数据。
     * （由 Curosr 自动生成）
     *
     * @return 轮播列表
     */
    private List<Banner> buildBanners() {
        return Arrays.asList(
                new Banner(1L,
                        "https://images.unsplash.com/photo-1607082348824-0a96f2a4b9da?auto=format&fit=crop&w=1200&q=80",
                        "/product/101", 1),
                new Banner(2L,
                        "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?auto=format&fit=crop&w=1200&q=80",
                        "/product/102", 2),
                new Banner(3L,
                        "https://images.unsplash.com/photo-1523275335684-37898b6baf30?auto=format&fit=crop&w=1200&q=80",
                        "/product/301", 3)
        );
    }

    /**
     * 构造推荐商品写死数据。
     * （由 Curosr 自动生成）
     *
     * @return 推荐商品列表
     */
    private List<ProductBrief> buildRecommendProducts() {
        return Arrays.asList(
                new ProductBrief(101L, "无线降噪耳机",
                        "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?auto=format&fit=crop&w=600&q=80",
                        new BigDecimal("199.00"), 36),
                new ProductBrief(102L, "20000mAh 充电宝",
                        "https://images.unsplash.com/photo-1609091839311-b140b7d1d0b4?auto=format&fit=crop&w=600&q=80",
                        new BigDecimal("89.00"), 80),
                new ProductBrief(301L, "电热水壶",
                        "https://images.unsplash.com/photo-1578662996442-48f60103fc96?auto=format&fit=crop&w=600&q=80",
                        new BigDecimal("129.00"), 45),
                new ProductBrief(401L, "运动外套",
                        "https://images.unsplash.com/photo-1556821840-3a63f95609a7?auto=format&fit=crop&w=600&q=80",
                        new BigDecimal("259.00"), 60)
        );
    }

    /**
     * 构造分类预览块写死数据（每类最多 3 个商品）。
     * （由 Curosr 自动生成）
     *
     * @return 分类块列表
     */
    private List<CategoryBlock> buildCategoryBlocks() {
        List<ProductBrief> digital = Arrays.asList(
                new ProductBrief(201L, "透明防摔手机壳",
                        "https://images.unsplash.com/photo-1601784551446-20c9e07cdbdb?auto=format&fit=crop&w=600&q=80",
                        new BigDecimal("29.90"), 100),
                new ProductBrief(202L, "Type-C 快充线",
                        "https://images.unsplash.com/photo-1583863788434-e58a36330cf0?auto=format&fit=crop&w=600&q=80",
                        new BigDecimal("19.90"), 200),
                new ProductBrief(101L, "无线降噪耳机",
                        "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?auto=format&fit=crop&w=600&q=80",
                        new BigDecimal("199.00"), 36)
        );
        List<ProductBrief> appliance = Arrays.asList(
                new ProductBrief(301L, "电热水壶",
                        "https://images.unsplash.com/photo-1578662996442-48f60103fc96?auto=format&fit=crop&w=600&q=80",
                        new BigDecimal("129.00"), 45),
                new ProductBrief(302L, "空气净化器",
                        "https://images.unsplash.com/photo-1585771724686-ae83b0b6c3c8?auto=format&fit=crop&w=600&q=80",
                        new BigDecimal("899.00"), 12)
        );
        List<ProductBrief> clothing = Collections.singletonList(
                new ProductBrief(401L, "运动外套",
                        "https://images.unsplash.com/photo-1556821840-3a63f95609a7?auto=format&fit=crop&w=600&q=80",
                        new BigDecimal("259.00"), 60)
        );
        return Arrays.asList(
                new CategoryBlock(1L, "手机数码", digital),
                new CategoryBlock(2L, "家用电器", appliance),
                new CategoryBlock(3L, "服装鞋帽", clothing)
        );
    }
}
