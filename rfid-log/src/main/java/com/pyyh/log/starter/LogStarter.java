package com.pyyh.log.starter;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

import ch.qos.logback.classic.Logger;

@ComponentScan(basePackages = {"com.pyyh.log"})
@EnableDiscoveryClient
@SpringBootApplication
public class LogStarter extends SpringBootServletInitializer{
	
	public static void main(String[] args){
		SpringApplication.run(LogStarter.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(LogStarter.class);
	}
}
