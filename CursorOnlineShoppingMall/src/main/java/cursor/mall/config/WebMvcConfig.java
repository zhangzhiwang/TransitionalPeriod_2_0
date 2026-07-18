package cursor.mall.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web MVC 配置：登录拦截与静态资源放行。
 * （由 Curosr 自动生成）
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /** 登录拦截器。 */
    private final LoginAuthInterceptor loginAuthInterceptor;

    /**
     * 构造注入拦截器。
     * （由 Curosr 自动生成）
     *
     * @param loginAuthInterceptor 登录拦截器
     */
    public WebMvcConfig(LoginAuthInterceptor loginAuthInterceptor) {
        this.loginAuthInterceptor = loginAuthInterceptor;
    }

    /**
     * 注册登录拦截：首页等需登录；登录注册与静态资源放行。
     * （由 Curosr 自动生成）
     *
     * @param registry 拦截器注册表
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginAuthInterceptor)
                .addPathPatterns("/", "/home", "/home/**",
                        "/category", "/category/**", "/categories", "/categories/**",
                        "/product/**", "/cart", "/cart/**",
                        "/orders", "/orders/**", "/addresses", "/addresses/**",
                        "/address/**", "/order/**", "/api/**")
                .excludePathPatterns(
                        "/login", "/register", "/me",
                        "/api/auth/login", "/api/auth/register", "/api/auth/send-register-code",
                        "/css/**", "/js/**", "/images/**",
                        "/WEB-INF/**");
    }

    /**
     * 显式映射静态资源（与 webapp 目录对应）。
     * （由 Curosr 自动生成）
     *
     * @param registry 资源注册表
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/images/**").addResourceLocations("/images/");
    }
}
