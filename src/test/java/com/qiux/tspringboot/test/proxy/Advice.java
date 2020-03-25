package com.qiux.tspringboot.test.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author qiuxian
 * @date 2020/3/25
 */
@Aspect
@Component
public class Advice {


    @Before("execution(* com.qiux.tspringboot.test.proxy.MyComponent.*(..))")
    public void adviceCom() {
        System.out.println("myComponent");
    }

}
