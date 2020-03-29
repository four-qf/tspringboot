package com.qiux.tspringboot.test.reflect.reflecttype;

import com.qiux.tspringboot.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ResolvableType;

import java.lang.reflect.Field;

/**
 * @author qiuxian
 * @date 2020/3/25
 */
@Slf4j
public class ResolvableTypeTest<T> {
    public static void main(String[] args) throws Exception {

//        Student student = new Student();
        ResolvableType resolvableType = ResolvableType.forClass(SubStudent.class);
        log.info("generics:{}",resolvableType.getGenerics());
        log.info("interfaces:{}", resolvableType.getInterfaces());

        log.info("IsAssignableFrom Student:{}", Student.class.isAssignableFrom(SubStudent.class));

        log.info("type:{}",resolvableType.getType().getTypeName());
        log.info("ComponentType:{}", resolvableType.getComponentType());
        Field field = Student.class.getDeclaredField("name");
        System.out.println("genericType:" + field.getGenericType());
        log.info("Field:{}", ResolvableType.forField(field));
        log.info("Class<?>:{}", resolvableType.resolve(Student.class));


    }

//    public static void forField() throws Exception {
//        Field field = Fields.class.getField("charSequenceList");
//        ResolvableType type = ResolvableType.forField(field);
//        assertThat(type.getType(), equalTo(field.getGenericType()));
//    }
}
