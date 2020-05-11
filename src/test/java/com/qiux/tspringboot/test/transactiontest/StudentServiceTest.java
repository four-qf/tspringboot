package com.qiux.tspringboot.test.transactiontest;

import com.qiux.tspringboot.entity.Student;
import com.qiux.tspringboot.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qiuxian
 * @date 2020/5/8
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void updatePhoneById() {
        System.out.println(studentService.updatePhoneById("18981752565134", 2));
    }

    @Test
    public void insertPhone(){
        Student student = new Student();
        student.setPhone("18981752567");
        student.setName("qx");
        student.setGrade("本科");
        System.out.println(studentService.save(student));
    }


}
