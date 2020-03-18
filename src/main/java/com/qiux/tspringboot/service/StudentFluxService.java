package com.qiux.tspringboot.service;

import com.qiux.tspringboot.entity.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author qiuxian
 * @date 2020/3/16
 */
public interface StudentFluxService {

    Flux<Student> list();

//    Flux<Student> getById(final Flux<String> ids);

    Mono<Student> getById(Integer id);

    Mono<Student> create(final Student student);

    Mono<Integer> delete(final Integer id);

}
