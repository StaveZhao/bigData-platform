package com.bigData.service.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.bigData.service.system.api.feign"})
@SpringBootApplication
public class BigDataFileApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigDataFileApplication.class);
    }

}
