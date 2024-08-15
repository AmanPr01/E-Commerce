package dev.aman.fakestorepractice.Configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean
    @LoadBalanced // This annotation is used by load balancer so that product service can talk to load balancer.
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
