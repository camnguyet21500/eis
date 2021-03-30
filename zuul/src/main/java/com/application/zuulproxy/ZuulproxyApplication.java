package com.application.zuulproxy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.spi.json.JacksonJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableFeignClients
public class ZuulproxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulproxyApplication.class, args);
	}

	@Bean
	public com.jayway.jsonpath.Configuration configuration(@Autowired ObjectMapper objectMapper) {
		return com.jayway.jsonpath.Configuration.builder()
				.jsonProvider(new JacksonJsonProvider(objectMapper))
				.mappingProvider(new JacksonMappingProvider(objectMapper))
				.options(com.jayway.jsonpath.Option.DEFAULT_PATH_LEAF_TO_NULL)
				.options(com.jayway.jsonpath.Option.SUPPRESS_EXCEPTIONS).build();
	}
}
