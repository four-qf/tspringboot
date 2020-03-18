package com.qiux.tspringboot.service.impl;

import com.qiux.tspringboot.entity.Student;
import com.qiux.tspringboot.mapper.StudentMapper;
import com.qiux.tspringboot.service.StudentFluxService;
import com.qiux.tspringboot.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author qiuxian
 * @date 2020/3/16
 */
@Service
public class StudentFluxServiceImpl implements StudentFluxService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Flux<Student> list() {
        return (Flux<Student>) studentMapper.selectAll();
    }

//    @Override
//    public Flux<Student> getById(Flux<String> ids) {
////        return studentMapper.se;
//        return null;
//    }

    @Override
    public Mono<Student> getById(Integer id) {
        return Mono.just(studentMapper.selectByPrimaryKey(id)).
                switchIfEmpty(Mono.error(new ResourceNotFoundException()));
    }

    @Override
    public Mono<Student> create(Student student) {
        studentMapper.insert(student);
        return Mono.just(student);
    }

    @Override
    public Mono<Integer> delete(Integer id) {
        return Mono.justOrEmpty(studentMapper.deleteByPrimaryKey(id));
    }
}
