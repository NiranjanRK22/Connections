package com.gatewayapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConnectionsGatewayApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConnectionsGatewayApiApplication.class, args);
	}

}
