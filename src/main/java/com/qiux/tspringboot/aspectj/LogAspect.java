package com.qiux.tspringboot.aspectj;

import com.qiux.tspringboot.entity.param.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

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
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        LoginUser loginUser = (LoginUser) requestAttributes.getAttribute("LoginUser", RequestAttributes.SCOPE_REQUEST);
        log.info("LogAspect-----------args:{} | method:{} | loginuser:{}", Arrays.toString(args), signature.getName(), loginUser);
    }

}
