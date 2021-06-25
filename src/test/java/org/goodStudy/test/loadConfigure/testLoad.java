package org.goodStudy.test.loadConfigure;

import org.goodStudy.bean.Animal;
import org.goodStudy.configure.loadConfigure.ConfigurationPropertiesLoad;
import org.goodStudy.configure.loadConfigure.PropertySourceLoad;
import org.goodStudy.configure.loadConfigure.VauleLoad;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author dingws
 * @PackageName JavaStudy
 * @Package org.goodStudy.test.loadConfigure
 * @Date 2021/6/25 5:49 下午
 * @Version 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class testLoad {

    @Autowired
    ConfigurableApplicationContext context;

    @Test
    public void test(){
        System.out.println("context = " + context);
        System.out.println(context.getBeanNamesForType(Animal.class));
        System.out.println(context.getBeanNamesForType(VauleLoad.class));
//        System.out.println(context.getBeansOfType(PropertySourceLoad.class));
//        System.out.println(context.getBeansOfType(ConfigurationPropertiesLoad.class));
    }
}
