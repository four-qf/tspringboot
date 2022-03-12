package com.qiux.tspringboot.interceptor;

import com.qiux.tspringboot.entity.param.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author qiux
 * @Date 2022/3/12
 * @since
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("LoginInterceptor------------,path:{}", request.getContextPath());
        request.setAttribute("LoginUser", new LoginUser(19876, "admin"));
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
