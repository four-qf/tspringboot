package com.qiux.tspringboot.ctrl.webfluxtest;

import com.qiux.tspringboot.entity.Student;
import com.qiux.tspringboot.service.StudentFluxService;
import com.qiux.tspringboot.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author qiuxian
 * @date 2020/3/16
 */
@RestController
@RequestMapping("student-flux")
public class StudentFluxController {

    @Autowired
    private StudentFluxService studentFluxService;

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
    @ExceptionHandler(ResourceNotFoundException.class)
    public void notFound() {
    }

    @RequestMapping("/list")
    public Flux<Student> list() {
        return studentFluxService.list();
    }

    @RequestMapping("/show-one/{id}")
    public Mono<Student> getById(@PathVariable Integer id) {
        return studentFluxService.getById(id);
    }

    @RequestMapping("/create")
    public Mono<Student> createStudent(Student student) {
        if (student == null || StringUtils.isEmpty(student.getName())) {
            return Mono.error(new ResourceNotFoundException());
        }
        return studentFluxService.create(student);
    }

    @RequestMapping("/del/{id}")
    public Mono<Integer> del(@PathVariable Integer id){
        return studentFluxService.delete(id);
    }

    @RequestMapping("/show-name/{id}")
    public Mono<String> getNameById(@PathVariable Integer id) {
        Mono<Student> studentMono = studentFluxService.getById(id);
        if (studentMono != null) {
            return Mono.just(studentMono.block().getName());
        }
        return Mono.error(new ResourceNotFoundException());
    }

}
