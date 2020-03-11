package com.qiux.tspringboot.test.annontationtest;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author qiuxian
 * @date 2020/1/28
 */
//@Configuration
@Import({PeopleService.class})
public class ImportPeopleTest {

}
