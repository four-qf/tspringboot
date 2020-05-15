package com.qiux.tspringboot.service.impl;

import com.qiux.tspringboot.cache.StudentServiceCache;
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

    @Autowired
    private StudentServiceCache studentServiceCache;

    @Override
    public List<Student> findAll() {
        return studentMapper.selectAll();
    }

    @Override
    public Student getById(Integer id) {
        Student studentCache = studentServiceCache.getStudent(id);
        if (studentCache != null) {
            return studentCache;
        }
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public int updatePhoneById(String phone, Integer id) {
        Student student = new Student();
        student.setPhone(phone);
        student.setId(id);
        Student studentCache = getById(id);
        if (studentCache != null) {
            student.setPhone(phone);
            studentServiceCache.setStudent(student);
        }
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        int row = studentMapper.insert(student);
        if (row != 0) {
            studentServiceCache.setStudent(student);
        }
//        updatePhoneById("18981762565", student.getId());

        return row != 0 ? student : null;
    }




}
