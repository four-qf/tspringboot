package com.qiux.tspringboot.test.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.SpringProperties;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author qiuxian
 * @date 2020/4/9
 */
@Slf4j
public class ClassLoader2PropertiesFile {

    public static void main(String[] args) throws IOException {
//        ClassLoader classLoader = ClassLoader2PropertiesFile.class.getClassLoader();
//        Enumeration<URL> urlResources = classLoader.getResources("META-INF/NOTICE");
//        while (urlResources.hasMoreElements()) {
//            URL url = urlResources.nextElement();
//            System.out.println(url);
//        }
//        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
//        System.out.println(defaultResourceLoader.getClassLoader());
//        System.out.println(defaultResourceLoader.getProtocolResolvers());
//        System.out.println(defaultResourceLoader.getResource("classpath:springboot.properties").getURL());
//        
        ClassLoader cl = SpringProperties.class.getClassLoader();
        URL url = (cl != null ? cl.getResource("spring.properties") :
                ClassLoader.getSystemResource("spring.properties"));
        log.info("url:{}",url);
    }

}
