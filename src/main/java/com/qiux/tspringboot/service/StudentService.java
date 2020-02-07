package com.qiux.tspringboot.service;

import com.qiux.tspringboot.entity.Student;

import java.util.List;

/**
 * @author qiuxian
 * @date 2020/2/4
 */
public interface StudentService {

    List<Student> findAll();

    Student getById(Integer id);

}
