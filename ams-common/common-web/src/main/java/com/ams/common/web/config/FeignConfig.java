package com.ams.common.web.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @ClassName : { FeignConfig }
 * @Author : {whisper}
 * @Date : {Created in 15:44 2022/1/22}
 */
@Configuration
@SuppressWarnings("all")
public class FeignConfig {
    @Value("${spring.application.name}")
    private String applicationName;


    /**
     * 让DispatcherServlet 向子线程传递Requestontext
     * @param servlet
     * @return 注册Bean
     */
    @Bean
    public ServletRegistrationBean<DispatcherServlet> dispatcherRegistration(DispatcherServlet servlet){
        servlet.setThreadContextInheritable(true);
        return new ServletRegistrationBean<>(servlet,"/**");
    }

    /**
     * 覆写拦截器 在feign发送请求前取出原来的header并转发
     * 在经过网关后 A服务在调用B服务的时候 将A服务的请求头转发给B服务
     * @return 拦截器
     */
    @Bean
    public RequestInterceptor requestInterceptor(){
        return (template)-> {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            //获取请求头
            Enumeration<String> headerNames = request.getHeaderNames();
            if (headerNames != null) {
                while (headerNames.hasMoreElements()) {
                    String name = headerNames.nextElement();
                    String values = request.getHeader(name);
                    //将请求头保存到模板中
                    template.header(name, values);
                }
                System.out.println("当前服务名称:" + applicationName);
                template.header("serviceName", applicationName);
            }

        };
        }

}
