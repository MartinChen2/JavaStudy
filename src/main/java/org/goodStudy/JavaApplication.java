package org.goodStudy;

import org.goodStudy.bean.Animal;
import org.goodStudy.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package PACKAGE_NAME
 * @Date 2021/5/13 4:14 下午
 * @Version 1.0
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
@EnableAsync
public class JavaApplication {
    public static void main(String[] args) {
        System.out.println("======main启动=======");
        SpringApplication.run(JavaApplication.class, args);
        System.out.println("======main停止==========");
    }
}
