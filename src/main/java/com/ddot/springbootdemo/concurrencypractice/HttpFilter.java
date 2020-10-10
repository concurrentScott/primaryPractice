package com.ddot.springbootdemo.concurrencypractice;

import com.ddot.springbootdemo.concurrencypractice.test.threadlocal.RequestHolder;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {



    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        //req.getSession().getAttribute("user");
        /**打印当先线程以及当前请求*/
        log.info("do filter,{},{}",Thread.currentThread(),req.getServletPath());
        RequestHolder.add(Thread.currentThread().getId());
        /**请求能继续下去*/
        chain.doFilter(req,response);
    }

    @Override
    public void destroy() {

    }

    public static void main(String[] args) {
        List<String> a = Lists.newArrayList("1.1","2.2","3.3");
        List<String> collect = a.stream()
                .map(e -> e.split(""))
                .flatMap(strings -> Arrays.stream(strings))
                .collect(Collectors.toList());

        System.out.println(collect);
    }
}
