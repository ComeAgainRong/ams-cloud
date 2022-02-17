package com.ams.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @ClassName : { AdminApp }
 * @Author : {whisper}
 * @Date : {Created in 14:51 2022/2/2}
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class AdminApp {
     public static void main(String[] args) {
           SpringApplication.run(AdminApp.class, args);
      }
     
}
