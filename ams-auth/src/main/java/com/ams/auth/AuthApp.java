package com.ams.auth;

import com.ams.admin.api.OAuthClientFeignClient;
import com.ams.admin.api.UserFeignClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName : { AuthApp }
 * @Author : {whisper}
 * @Date : {Created in 17:19 2022/1/22}
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackageClasses = {UserFeignClient.class, OAuthClientFeignClient.class})
public class AuthApp {
     public static void main(String[] args) {
           SpringApplication.run(AuthApp.class, args);
      }
     
}
