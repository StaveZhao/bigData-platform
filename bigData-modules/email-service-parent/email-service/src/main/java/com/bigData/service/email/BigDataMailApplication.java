package com.bigData.service.email;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.bigData.service.system.api.feign"})
@SpringCloudApplication
public class BigDataMailApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigDataMailApplication.class);
    }

}
