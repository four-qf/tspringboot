package com.qiux.tspringboot.test.reflect.type;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ResolvableType;

/**
 * @author qiuxian
 * @date 2020/3/25
 */
@Slf4j
public class RosolverTest<T> {
    public static void main(String[] args) {
        TypeBean typeBean = new TypeBean();
        ResolvableType resolvableType = ResolvableType.forInstance(typeBean);
        log.info("generics:{}",resolvableType.getGenerics());
        log.info("interfaces:{}", resolvableType.getInterfaces());
        log.info("isAssignableFrom ClassTest:{}", resolvableType.isAssignableFrom(ClassTest.class));
        log.info("type:{}",resolvableType.getSuperType().getType());

    }
}
