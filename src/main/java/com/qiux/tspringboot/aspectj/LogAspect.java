package com.qiux.tspringboot.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author qiux
 * @Date 2022/3/12
 * @since
 */
@Configuration
@Slf4j
@Aspect
public class LogAspect {

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(final JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        log.info("LogAspect-----------args:{} | method:{}", Arrays.toString(args), signature.getName() );
    }

}
