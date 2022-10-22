package com.qiux.tspringboot.ctrl;

import com.qiux.tspringboot.entity.param.Test;
import com.qiux.tspringboot.service.TestService;
import com.qiux.tspringboot.service.TestServiceFactory;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiux
 * @Date 2022/10/18
 * @since
 */
@RequestMapping("/test")
@RestController
public class TestContoller {

    @Autowired
    private TestServiceFactory serviceFactory;


    @GetMapping("/testService")
    public String testServiceFactory(Test test, String type) {
        String submit = serviceFactory.testService(type).submit(test);
        return submit;
    }

}
