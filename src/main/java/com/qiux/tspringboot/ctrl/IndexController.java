package com.qiux.tspringboot.ctrl;

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

}
