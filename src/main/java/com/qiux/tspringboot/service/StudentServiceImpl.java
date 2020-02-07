package com.qiux.tspringboot.service;

import com.qiux.tspringboot.entity.Student;
import com.qiux.tspringboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qiuxian
 * @date 2020/2/4
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findAll() {
        return studentMapper.selectAll();
    }

    @Override
    public Student getById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
