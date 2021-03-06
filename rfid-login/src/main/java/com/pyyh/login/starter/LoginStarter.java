package com.pyyh.login.starter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.netflix.loadbalancer.RandomRule;
@ComponentScan(basePackages = {"com.pyyh.login"})
@MapperScan({"com.pyyh.login.dao"})
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.pyyh.login"})
public class LoginStarter extends SpringBootServletInitializer{

	public static void main(String[] args){
		SpringApplication.run(LoginStarter.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(LoginStarter.class);
	}
	@Bean
	public RandomRule randomRule(){
		return new RandomRule();
	}
}
