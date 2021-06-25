package org.goodStudy.configure.loadConfigure;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.configure.loadConfigure
 * @Date 2021/6/25 5:40 下午
 * @Version 1.0
 */
@PropertySource(value = "application.yaml")
@Data
public class PropertySourceLoad {

    @Value("${info.name}")
    private String name;

    @Value("${info.version}")
    private String version;

    @Value("${info.author}")
    private String author;
}
