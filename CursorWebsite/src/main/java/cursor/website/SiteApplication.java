package cursor.website;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * CursorWebsite Spring Boot 启动类（JDK8 + Spring Boot 2.7）。
 * （由 Curosr 自动生成）
 */
@SpringBootApplication
@MapperScan("cursor.website.mapper")
public class SiteApplication extends SpringBootServletInitializer {

    /**
     * 外置 Tomcat 部署时的配置入口。
     * （由 Curosr 自动生成）
     *
     * @param builder Spring 应用构造器
     * @return 已指定主类的构造器
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SiteApplication.class);
    }

    /**
     * 本地以内嵌 Tomcat 启动。
     * （由 Curosr 自动生成）
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(SiteApplication.class, args);
    }
}
