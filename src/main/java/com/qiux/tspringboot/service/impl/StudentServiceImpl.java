package com.qiux.tspringboot.service.impl;

import com.qiux.tspringboot.entity.Student;
import com.qiux.tspringboot.mapper.StudentMapper;
import com.qiux.tspringboot.service.StudentService;
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

    @Override
    public List<Student> findAll() {
        return studentMapper.selectAll();
    }

    @Override
    public Student getById(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public int updatePhoneById(String phone, Integer id) {
        Student student = new Student();
        student.setPhone(phone);
        student.setId(id);
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        int row = studentMapper.insert(student);
        updatePhoneById("18981762565", student.getId());
        return row != 0 ? student : null;
    }




}
