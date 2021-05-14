package org.goodStudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.goodStudy.bean.Animal;
import org.goodStudy.bean.Person;
import org.goodStudy.bean.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.inject.Inject;

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
     * 1、@Resource是JSR250规范的实现，需要导入javax.annotation实现注入。
     *
     * 2、@Resource是根据名称进行自动装配的，一般会指定一个name属性
     *
     * 3、@Resource可以作用在变量、setter方法上。
     */
    @Resource
    Person person;

    /**
     * 1、@Autowired是spring自带的注解，通过‘AutowiredAnnotationBeanPostProcessor’ 类实现的依赖注入；
     *
     * 2、@Autowired是根据类型进行自动装配的，如果找到多个类型相同的，会按照名称进行匹配，如果名称相同，会报错，如果需要按指定名称进行装配，则需要配合@Qualifier；
     *
     * 3、@Autowired有个属性为required，可以配置为false，如果配置为false之后，当没有找到相应bean的时候，系统不会抛错；
     *
     * 4、@Autowired可以作用在变量、setter方法、构造函数上。
     */
    @Autowired
    Animal animal;

    /**
     * 1、@Inject是JSR330 (Dependency Injection for Java)中的规范，需要导入javax.inject.Inject;实现注入。
     *
     * 2、@Inject是根据类型进行自动装配的，如果需要按名称进行装配，则需要配合@Named；
     *
     * 3、@Inject可以作用在变量、setter方法、构造函数上。
     */
    @Inject
    Plant plant;

    /**
     * 本地浏览器输入：http://localhost:8088/test/hello
     * @return
     */
    @RequestMapping("/hello")
    public String getTestInfo(){
        log.info("收到请求");
        return "hello spring boot" + plant.toString();
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
