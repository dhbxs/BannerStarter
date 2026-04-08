package top.dhbxs.demo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.dhbxs.demo.properties.BannerProperties;
import top.dhbxs.demo.service.BannerService;

/**
 * Banner 自动配置类
 *
 * @author dhbxs
 * @since 2026/4/8
 */
@Configuration
// 如果当前类路径下有 BannerService 这个类，就把当前类加入 IoC 容器
@ConditionalOnClass(BannerService.class)
// 注册属性组件，SpringBoot 会读取用户在配置文件中指定的值，注入属性组件
@EnableConfigurationProperties(BannerProperties.class)
public class BannerAutoConfiguration {

    private final BannerProperties bannerProperties;

    public BannerAutoConfiguration(BannerProperties bannerProperties) {
        this.bannerProperties = bannerProperties;
    }

    @Bean
    // 条件注入 当 IoC 容器中没有这个 bean 时，才把返回对象注入到 IoC 容器中，如果有，则不注入
    @ConditionalOnMissingBean
    public BannerService bannerService() {
        // 创建BannerService时，把用户配置的是否启用也传进去
        return new BannerService(bannerProperties.getEnable());
    }
}
