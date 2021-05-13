package org.goodStudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.controller
 * @Date 2021/5/13 5:35 下午
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    /**
     * 本地浏览器输入：http://localhost:8088/test/hello
     * @return
     */
    @RequestMapping("/hello")
    public String getTestInfo(){
        log.info("收到请求");
        return "hello spring boot";
    }

    /**
     * get请求方式
     * @param param
     * @return
     */
    @RequestMapping("/getTypeReq")
    public String getTypeReq(@RequestParam String param){
        log.info("收到get请求, param =" + param);
        return "收到get请求";
    }

    /**
     * post请求方式
     * @param param
     * @return
     */
    @RequestMapping("/postTypeReq")
    public String postTypeReq(@RequestBody String param){
        log.info("收到post请求, param =" + param);
        return "收到post请求";
    }

    /**
     * 获取http header 信息
     * @return
     */
    @RequestMapping("/getHeaderInfo")
    public String getHeaderInfo(@RequestHeader HttpHeaders httpHeaders){
        log.info("收到请求, http header info = " + httpHeaders);
        return "收到请求, http header info = " + httpHeaders;
    }
}
