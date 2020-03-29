package com.qiux.tspringboot.test.reflect.reflecttype;

import com.qiux.tspringboot.entity.Student;
import lombok.Data;

/**
 * @author qiuxian
 * @date 2020/3/29
 */
@Data
public class SubStudent extends Student {

    private String child;

}
