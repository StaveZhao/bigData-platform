package com.bigData.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BigDataGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BigDataGatewayApplication.class, args);
    }

}
