package top.dhbxs.demo.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

/**
 * 打印 Banner 业务类
 *
 * @author dhbxs
 * @since 2026/4/8
 */
public class BannerService {

    // 是否启用
    private final Boolean enable;

    public BannerService(Boolean enable) {
        this.enable = enable;
        this.print();
    }

    /**
     * 从classpath读取banner.txt并打印到控制台
     *
     * @param bannerPath classpath下的路径，如 "banner.txt" 或 "static/banner.txt"
     */
    public void print(String bannerPath) {
        try (InputStream is = BannerService.class.getClassLoader().getResourceAsStream(bannerPath)) {
            if (is == null) {
                System.out.println("Banner not found: " + bannerPath);
                return;
            }
            String banner = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));
            System.out.println(banner);
        } catch (Exception e) {
            System.out.println("Failed to print banner: " + e.getMessage());
        }
    }

    /**
     * 使用默认路径 banner.txt
     */
    public void print() {
        if (Boolean.TRUE.equals(this.enable)) {
            print("dhbxs/banner.txt");
        }
    }
}
