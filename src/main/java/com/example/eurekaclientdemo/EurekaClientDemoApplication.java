package com.example.eurekaclientdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Eureka 客户端，会在注册中心注册自己
 * @author xxlai
 *
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
public class EurekaClientDemoApplication {
	@Value("${server.port}")
	private String port;
	
	@GetMapping("/hello/{name}")
	public String home(@PathVariable String name){
		System.out.println(name+" welcome .My is hello1");
		return "hello "+name+",i am from port:" +port;
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientDemoApplication.class, args);
	}
}
