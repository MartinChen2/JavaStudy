package org.goodStudy.test;

import org.goodStudy.utils.RestTemplateUtils;
import org.goodStudy.bean.Animal;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.test
 * @Date 2021/5/14 6:56 下午
 * @Version 1.0
 */
@SpringBootApplication
public class testUtil {

    public static void main(String[] args) {
        RestTemplateUtils restTemplateUtils = new RestTemplateUtils();
        String url = "http://localhost:8090/test/test";
        String resonse = restTemplateUtils.post(url, new Animal());
        System.out.println(resonse);
    }
}
