package org.goodStudy.config.loadConfigure;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.configure.loadConfigure
 * @Date 2021/6/25 5:40 下午
 * @Version 1.0
 */
@Component
@PropertySource(value = "classpath:/test.properties")
@Data
public class PropertySourceLoad {

    @Value("${info.name}")
    private String name;

    @Value("${info.version}")
    private String version;

    @Value("${info.author}")
    private String author;
}
