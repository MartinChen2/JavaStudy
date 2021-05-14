package org.goodStudy.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.bean
 * @Date 2021/5/14 2:01 下午
 * @Version 1.0
 */
@Configuration
public class beanFactory {

    @Bean
    public Person createPersion(){
        return new Person();
    }
}
