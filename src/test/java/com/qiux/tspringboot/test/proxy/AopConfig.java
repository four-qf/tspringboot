package com.qiux.tspringboot.test.proxy;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author qiuxian
 * @date 2020/3/25
 */
@EnableAspectJAutoProxy
@ComponentScan("com.qiux.tspringboot.test.proxy")
public class AopConfig {
}
