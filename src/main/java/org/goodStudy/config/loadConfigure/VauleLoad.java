package org.goodStudy.config.loadConfigure;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.configure
 * @Date 2021/6/25 5:29 下午
 * @Version 1.0
 */
@Component
@Data
public class VauleLoad {

    @Autowired
    ApplicationContext applicationContext;

    @Value("${info.name}")
    private String name;

    @Value("${info.version}")
    private String version;

    @Value("${info.author}")
    private String author;

    @Scheduled(initialDelay = 10, fixedDelay = 100000000)
    @Async
    void print(){
        System.out.print("name = " + name);
        System.out.print("context get = " + applicationContext.getBean(PropertySourceLoad.class));
    }
}
