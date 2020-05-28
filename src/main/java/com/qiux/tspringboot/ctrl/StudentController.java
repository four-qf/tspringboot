package com.qiux.tspringboot.ctrl;

import com.qiux.tspringboot.entity.Student;
import com.qiux.tspringboot.service.StudentService;
import com.qiux.tspringboot.mq.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author qiuxian
 * @date 2020/2/4
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private RabbitMqSender rabbitMqSender;

    @RequestMapping("/select-all")
    public List<Student> showAll() {
        return studentService.findAll();
    }

    @RequestMapping("/get/{id}")
    public Student getStudentById(@PathVariable Integer id) throws UnsupportedEncodingException {
        Student student = studentService.getById(id);
        rabbitMqSender.send(student);
        return student;
    }

    @RequestMapping("/create")
    public Object createStudent(Student student) {
        if(student == null || StringUtils.isEmpty(student.getName()) || student.getAge() == null ) {
            return "请输入信息";
        }
        return studentService.save(student);
    }

}
