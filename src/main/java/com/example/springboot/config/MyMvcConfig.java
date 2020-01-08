package com.example.springboot.config;

import com.example.springboot.component.LoginHandlerInterceptor;
import com.example.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.Arrays;

//@EnableWebMvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);

    }

    // 所有的WebconfigureAdapter组件都会一起起作用
    @Bean // 将组件注册在容器
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

//            // 注册拦截器
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                // super.addInterceptors(registry);
//                // 静态资源； *.css,*.js
//                // springBoot已经做好了静态资源映射
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")//任意多层路径下的任意请求
//                        .excludePathPatterns("/index.html", "/", "/user/login","/resources/**","/static/**","/public/**","/templates/**");
//
//            }
        };

        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

}
