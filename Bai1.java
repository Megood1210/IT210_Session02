package hello.world.session2;

//Phần 1
//1."/api/*" khiến mọi request đến /welcome đều bị 404. DispatcherServlet đang nghe những URL nào với cấu hình
//này vì "/api/*" khiến DispatcherServlet không nghe URL /welcome
//2.Lỗi trong WebConfig.java: @ComponentScan(basePackages = "com.demo.service") gây ra hậu quả
//+Không tìm thấy WelcomeController
//+Không tạo bean controller
//+Không có mapping /welcome
//3.Spring MVC tìm @Controller ở com.demo.controller và không thể tìm thấy ở WelcomeController theo cấu hình

//Phần 2
//package com.demo.config;
//
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return null;
//    }
//
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class<?>[] { WebConfig.class };
//    }
//
//    @Override
//    protected String[] getServletMappings() {
//        return new String[] { "/" };
//    }
//}
//
//package com.demo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = "com.demo")
//public class WebConfig {
//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF/views/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
//}