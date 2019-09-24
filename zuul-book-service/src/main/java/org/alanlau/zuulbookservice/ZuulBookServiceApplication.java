package org.alanlau.zuulbookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZuulBookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulBookServiceApplication.class, args);
    }

}
