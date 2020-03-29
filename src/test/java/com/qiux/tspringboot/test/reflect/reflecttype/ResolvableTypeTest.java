package com.qiux.tspringboot.test.reflect.reflecttype;

import com.qiux.tspringboot.test.reflect.type.EnumTest;
import com.qiux.tspringboot.test.reflect.type.TypeBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ResolvableType;

/**
 * @author qiuxian
 * @date 2020/3/25
 */
@Slf4j
public class ResolvableTypeTest<T> {
    public static void main(String[] args) {
        TypeBean typeBean = new TypeBean();
        ResolvableType resolvableType = ResolvableType.forInstance(typeBean);
        log.info("generics:{}",resolvableType.getGenerics());
        log.info("interfaces:{}", resolvableType.getInterfaces());
        log.info("isAssignableFrom ClassTest:{}", resolvableType.isAssignableFrom(EnumTest.class));
        log.info("type:{}",resolvableType.getSuperType().getType());

    }
}
