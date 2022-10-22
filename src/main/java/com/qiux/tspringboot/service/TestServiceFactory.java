package com.qiux.tspringboot.service;

import com.qiux.tspringboot.service.impl.TestProductServiceImpl;
import com.qiux.tspringboot.service.impl.TestUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiux
 * @Date 2022/10/19
 * @since
 */
@Configuration
public class TestServiceFactory {

    private TestService testService;

    @Autowired
    private ApplicationContext applicationContext;

    public TestService testService(String type) {

        if (type.equals("1")) {
//            applicationContext = new AnnotationConfigServletWebServerApplicationContext("com.qiux.tspringboot.ctrl.TestContoller");
            testService = applicationContext.getBean(TestUserServiceImpl.class);
            return testService;
        }
        if (type.equals("2")) {
            testService = applicationContext.getBean(TestProductServiceImpl.class);
            return testService;
        }
        return null;

    }

}
