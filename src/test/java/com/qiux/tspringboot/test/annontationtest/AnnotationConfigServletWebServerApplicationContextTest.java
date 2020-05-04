package com.qiux.tspringboot.test.annontationtest;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.core.env.EnvironmentCapable;

/**
 * @author qiuxian
 * @date 2020/4/13
 */
public class AnnotationConfigServletWebServerApplicationContextTest {

    public static void main(String[] args) {
        AnnotationConfigServletWebServerApplicationContext context = new AnnotationConfigServletWebServerApplicationContext();
        BeanDefinitionRegistry registry = context;

        System.out.println(registry instanceof EnvironmentCapable);

    }

}
