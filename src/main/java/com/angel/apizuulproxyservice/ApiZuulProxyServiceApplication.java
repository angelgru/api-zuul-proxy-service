package com.angel.apizuulproxyservice;

import com.angel.apizuulproxyservice.filters.PostFilter;
import com.angel.apizuulproxyservice.filters.PreFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ApiZuulProxyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiZuulProxyServiceApplication.class, args);
    }

    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }

    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
}
