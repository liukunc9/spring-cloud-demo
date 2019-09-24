package org.alanlau.eurekaprovider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Scanner;

@SpringBootApplication
@EnableEurekaClient
public class EurekaProviderApplication {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String port = scan.nextLine();

        new SpringApplicationBuilder(EurekaProviderApplication.class)
                .properties("server.port=" + port)
                .run(args);
    }

}