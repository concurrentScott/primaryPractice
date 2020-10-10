package com.ddot.springbootdemo.concurrencypractice;

import com.ddot.springbootdemo.concurrencypractice.test.threadlocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("*********front**************请求路径{}" + request.getServletPath());
        log.info("prehandle");
        return true;
    }



    //方法结束时一定会执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("***********back************请求路径{}" + request.getServletPath());
        RequestHolder.remove();
        return;
    }
}
