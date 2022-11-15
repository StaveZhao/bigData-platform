package com.bigData.service.system;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableFeignClients(basePackages = {"com.bigData.service.system.api.feign"})
@SpringCloudApplication
public class BigDataSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigDataSystemApplication.class);
    }

}
