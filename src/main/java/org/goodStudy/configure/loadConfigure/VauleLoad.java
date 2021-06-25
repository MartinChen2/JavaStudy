package org.goodStudy.configure.loadConfigure;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.configure
 * @Date 2021/6/25 5:29 下午
 * @Version 1.0
 */
@Data
public class VauleLoad {

    @Value("${info.name}")
    private String name;

    @Value("${info.version}")
    private String version;

    @Value("${info.author}")
    private String author;
}
