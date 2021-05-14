package org.goodStudy.bean;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Component;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.bean
 * @Date 2021/5/14 2:31 下午
 * @Version 1.0
 */
@Component
@Slf4j
public class Animal {
    private String eat;
    private String run;

    Animal(){
        log.info("Animal 构造函数");
    }
}
