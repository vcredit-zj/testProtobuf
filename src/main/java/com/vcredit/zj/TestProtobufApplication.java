package com.vcredit.zj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TestProtobufApplication {


    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    public static void main(String[] args) {
        SpringApplication.run(TestProtobufApplication.class, args);
    }
}
