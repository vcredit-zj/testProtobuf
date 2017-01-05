package com.vcredit.zj.controller;

import com.vcredit.zj.bean.Greeting;
import com.vcredit.zj.bean.proto.BookOuterClass;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shibenli on 2017/1/5.
 */

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody
    Greeting sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), name, "hello world");
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    @RequestMapping(path = "/proto", method=RequestMethod.GET)
    public @ResponseBody BookOuterClass.Book indexProto() {
        BookOuterClass.Book.Builder bookBuilder = BookOuterClass.Book.newBuilder();
        bookBuilder.setId(111).setName("benli").setDesc("hello world");
        return bookBuilder.build();
    }
}
