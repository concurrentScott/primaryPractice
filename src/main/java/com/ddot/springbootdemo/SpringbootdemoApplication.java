package com.ddot.springbootdemo;

import com.ddot.springbootdemo.concurrencypractice.HttpFilter;
import com.ddot.springbootdemo.concurrencypractice.HttpInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@MapperScan("com.ddot.springbootdemo.mapper")
public class SpringbootdemoApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplication.class, args);
    }


    @Bean
    public FilterRegistrationBean httpFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new HttpFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
    }
}
