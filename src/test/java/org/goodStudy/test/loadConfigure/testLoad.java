package org.goodStudy.test.loadConfigure;

import org.goodStudy.JavaApplication;
import org.goodStudy.config.loadConfigure.ConfigurationPropertiesLoad;
import org.goodStudy.config.loadConfigure.PropertySourceLoad;
import org.goodStudy.config.loadConfigure.VauleLoad;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.test.loadConfigure
 * @Date 2021/6/25 5:49 下午
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JavaApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class testLoad {

    @Autowired
    ApplicationContext context;

    @Autowired
    ConfigurationPropertiesLoad configurationPropertiesLoad;

    @Autowired
    PropertySourceLoad propertySourceLoad;

    @Autowired
    VauleLoad vauleLoad;

    @Test
    public void test(){
        String[] ayyry = {"ddd", "ddd"};
        System.out.println("context = " + context);
        System.out.println(configurationPropertiesLoad);
        System.out.println(propertySourceLoad);
        System.out.println(vauleLoad);

        System.out.println("---------------------------");
        System.out.println(context.getBean(PropertySourceLoad.class));
//        System.out.println(context.getBeansOfType(ConfigurationPropertiesLoad.class));
    }
}
