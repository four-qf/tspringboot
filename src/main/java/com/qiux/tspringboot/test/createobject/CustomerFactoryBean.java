package com.qiux.tspringboot.test.createobject;

import com.qiux.tspringboot.service.TestService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author qiux
 * @Date 2022/2/12
 * @since
 */
@Component
public class CustomerFactoryBean implements FactoryBean<TestService> {
//    @Override
//    public TestService getObject() throws Exception {
//        return new TestService();
//    }

    @Override
    public TestService getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return TestService.class;
    }

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.qiux.tspringboot.test.createobject");
        System.out.println("容器启动完成");
        TestService testService = applicationContext.getBean(TestService.class);
        System.out.println(testService);
        Object customerFactoryBean = applicationContext.getBean("customerFactoryBean");
        System.out.println(customerFactoryBean);

        Object bean = applicationContext.getBean("&customerFactoryBean");
        System.out.println(bean);

    }
}
