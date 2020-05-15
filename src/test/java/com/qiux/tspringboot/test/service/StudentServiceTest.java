package com.qiux.tspringboot.test.service;

import com.qiux.tspringboot.cache.StudentServiceCache;
import com.qiux.tspringboot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qiuxian
 * @date 2020/5/15
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentServiceTest {

    @Autowired
    private StudentServiceCache studentServiceCache;

    @Autowired
    private StudentService studentService;

    private Integer studentId = 2;

    @Test
    public void getStudent() {
        log.info("student : {}", studentService.getById(studentId));
    }

    @Test
    public void update() {
        System.out.println(studentService.updatePhoneById("16601364175", studentId));
    }

    @Test
    public void getStudentCache() {
        log.info("student cache : {}" , studentServiceCache.getStudent(studentId));
    }

}
