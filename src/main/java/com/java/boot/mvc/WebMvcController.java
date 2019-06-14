package com.java.boot.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.*;
import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: Summer
 * @Date: 2019/6/8 18:46
 * @Description: No Description
 */
@Configuration
public class WebMvcController implements WebMvcConfigurer {

    @Resource
    private DateConverter dateConverter;
    @Resource
    private LoginInterceptor loginInterceptor;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(dateConverter);
    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//
//        InterceptorRegistration ir = registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
//        ir.excludePathPatterns("/static/**");//静态资源
//        ir.excludePathPatterns("/ant/loginpage");//登录页面
//        ir.excludePathPatterns("/ant/login");//登录操作
//
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/Path/**").addResourceLocations("file:/E:/picture/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ant/loginpage").setViewName("Login");
        registry.addViewController("/test").setViewName("test/Test");
    }
}
