package org.goodStudy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.controller
 * @Date 2021/5/13 5:35 下午
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    public String getTestInfo(){
        return "hello spring boot";
    }
}
