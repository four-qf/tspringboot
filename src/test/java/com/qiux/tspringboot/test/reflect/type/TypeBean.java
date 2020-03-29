package com.qiux.tspringboot.test.reflect.type;

import com.qiux.tspringboot.test.reflect.reflecttype.ResolvableTypeTest;
import lombok.Data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;

@Data
public class TypeBean<T> {

    private T t;
    private String string;
    private Class<?> clazz;
    private Map<String,String> map;
    private List<String>[] lists;
    private List<T> list;
    private ResolvableTypeTest<T> rosolverTest;
    private ResolvableTypeTest<?> rosolverRosolverTest;

    private Address address;

    private ClassTest classTest;
    private Object object;
    private int aint;
    private T[] tArray;
    private int[] intAarry;
    private Integer[] integers;
    private EnumTest enumTest;
    private InterfaceTest interfaceTest;
    private AnnotationTest annotationTest;

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface AnnotationTest {
    }
    public class Address {

    }
    public void showBean(List<? extends Address> addresses) {
        System.out.println("TypeBean method showBean test");
    }

}