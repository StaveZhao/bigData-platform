package com.bigData.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.bigData.service.system.api.feign"})
@SpringCloudApplication
public class BigDataAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigDataAuthApplication.class, args);
    }

}
