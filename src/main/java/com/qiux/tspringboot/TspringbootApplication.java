package com.qiux.tspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TspringbootApplication.class);
	}

}
