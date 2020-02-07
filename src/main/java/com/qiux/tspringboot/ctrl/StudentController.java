package com.qiux.tspringboot.ctrl;

import com.qiux.tspringboot.entity.Student;
import com.qiux.tspringboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/select-all")
    public List<Student> showAll() {
        return studentService.findAll();
    }

    @RequestMapping("/get/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentService.getById(id);
    }

}
