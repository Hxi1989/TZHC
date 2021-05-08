package com.hxscpro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages="controller")
public class HxscproApplication {

    public static void main(String[] args) {
        System.out.println("服务端生产者启动.....");
        SpringApplication.run(HxscproApplication.class, args);
    }

}
