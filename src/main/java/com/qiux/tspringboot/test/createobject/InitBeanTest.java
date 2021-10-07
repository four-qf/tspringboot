package com.qiux.tspringboot.test.createobject;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author qiuxian
 * @date 2021/8/25
 */
@Component("initBeanTest")
public class InitBeanTest implements InitializingBean {


    InitBeanTest() {
        System.out.println("construct------");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean.afterPropertiesSet------------");
    }


    public void init() {
        System.out.println("init---------");
    }

    @PostConstruct
    public void post() {
        System.out.println("@PostConstruct--------");
    }


    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(InitBeanTest.class);
        context.start();

        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        beanFactory.getBean("initBeanTest");

//        InitBeanTest initBeanTest = (InitBeanTest) context.getBean("initBeanTest", InitBeanTest.class);


    }

}
