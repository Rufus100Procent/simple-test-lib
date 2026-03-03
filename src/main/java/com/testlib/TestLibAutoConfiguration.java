package com.testlib;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class TestLibAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public GreetingService greetingService() {
        return new DefaultGreetingService();
    }

    @Bean
    public GreetingController greetingController(GreetingService greetingService) {
        return new GreetingController(greetingService);
    }
}
