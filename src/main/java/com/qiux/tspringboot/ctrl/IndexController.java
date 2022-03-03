package com.qiux.tspringboot.ctrl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiuxian
 *
 * @date 2020/1/25
 */
@RestController
public class IndexController {

    @RequestMapping("/index")
    public Object index() {
        return "hello";
    }

    @HystrixCommand(fallbackMethod="hystrixFallBack",
            commandProperties ={
                   @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),
                   @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="20")
            }
    )
    @RequestMapping("/getnum/{num}")
    public String testHystrix(@PathVariable("num") int num) {
        if(num<0){
            throw new RuntimeException("****id 不能负数");
        }
        return String.valueOf(num);
    }

    public String hystrixFallBack(@PathVariable("num") int num) {
        return "num不能为负数";
    }



}
