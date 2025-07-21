package br.cnietsche.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PickpayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PickpayApplication.class, args);
    }
}
