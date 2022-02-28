package com.ams.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName : { GatewayApp }
 * @Author : {whisper}
 * @Date : {Created in 17:02 2022/2/26}
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApp {
     public static void main(String[] args) {
           SpringApplication.run(GatewayApp.class, args);
      }
     
}
