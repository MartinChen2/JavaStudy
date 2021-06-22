package org.goodStudy.bean;

import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.bean
 * @Date 2021/5/14 2:49 下午
 * @Version 1.0
 */
@Component(value = "myPlant")
@Slf4j
public class Plant {

    Plant(){
        log.info("Plant 构造函数");
    }

    String test;
}
