package com.qiux.tspringboot.service;

import com.qiux.tspringboot.entity.Student;
import com.qiux.tspringboot.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * @author qiuxian
 * @date 2020/2/4
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

//    @Autowired
//    private StudentService studentService;

    @Override
    public List<Student> findAll() {
        return studentMapper.selectAll();
    }

    @Override
    public Student getById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        int row = studentMapper.insert(student);
        saveD();
        return row != 0 ? student : null;
    }

    @Transactional(propagation = Propagation.NEVER)
    public void saveD() {

    }




}
