package com.qiux.tspringboot.ctrl.webfluxtest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author qiuxian
 * @date 2020/3/16
 */
@RestController
public class BasicController {

    @RequestMapping("/hello_world")
    public Mono<String> sayHelloWorld() {
        return Mono.just("hello world");
    }

}
