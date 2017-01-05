package com.vcredit.zj;

import com.vcredit.zj.bean.proto.BookOuterClass;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringApplicationConfiguration(classes = TestProtobufApplication.class)
@SpringBootTest
public class TestProtobufApplicationTests {

	@Configuration
	public static class RestClientConfiguration {

		@Bean
		RestTemplate restTemplate(ProtobufHttpMessageConverter hmc) {
			return new RestTemplate(Arrays.asList(hmc));
		}

		@Bean
		ProtobufHttpMessageConverter protobufHttpMessageConverter() {
			return new ProtobufHttpMessageConverter();
		}
	}

	@Autowired
	private RestTemplate restTemplate;

	private int port = 9000;

	@Test
	public void contextLoaded() {

		ResponseEntity<BookOuterClass.Book> customer = restTemplate.getForEntity(
				"http://127.0.0.1:" + port + "hello-world/proto", BookOuterClass.Book.class);

		System.out.println("customer retrieved: " + customer.toString());

	}

	@Test
	public void contextJson() {

		ResponseEntity<BookOuterClass.Book> customer = restTemplate.getForEntity(
				"http://127.0.0.1:" + port + "hello-world?name=benli", BookOuterClass.Book.class);

		System.out.println("customer retrieved: " + customer.toString());

	}
}
