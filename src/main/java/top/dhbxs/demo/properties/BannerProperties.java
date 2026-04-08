package top.dhbxs.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Banner 是否启用配置类
 *
 * @author dhbxs
 * @since 2026/4/8
 */
@Component
@ConfigurationProperties(prefix = "banner")
public class BannerProperties {
    /**
     * 是否启用 Banner
     */
    private Boolean enable = true;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
