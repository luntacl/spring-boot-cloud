package com.github.tangram.runtime;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.github.tangram.runtime.core.*.dao")
//@EnableCircuitBreaker
//@EnableOAuth2Client
public class RuntimeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RuntimeServiceApplication.class, args);
    }

}