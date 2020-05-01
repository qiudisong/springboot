package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private ApplicationContext appContext;

    //输出应用上下文中的bean
    @Test
    void contextLoads() {
        String[] beanDefinitionNames = appContext.getBeanDefinitionNames();
        for (String beanDefinitionName:
                beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

}
