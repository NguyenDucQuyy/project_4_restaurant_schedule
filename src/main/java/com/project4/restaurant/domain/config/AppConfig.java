package com.project4.restaurant.domain.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  @Bean
  public Contract feignContract() {
    return new feign.Contract.Default();
  }
}
