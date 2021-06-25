package org.goodStudy.configure.loadConfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.configure.loadConfigure
 * @Date 2021/6/25 5:36 下午
 * @Version 1.0
 */
@Component
@ConfigurationProperties(prefix = "info")
@Data
public class ConfigurationPropertiesLoad {

    private String name;

    private String version;

    private String author;
}
