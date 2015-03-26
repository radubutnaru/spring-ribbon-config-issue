package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ExcludeFromComponentScan.class)
})
@EnableDiscoveryClient
@RibbonClient(name = "customers", configuration = CustomersRibbonConfiguration.class)
public class SampleApp {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleApp.class, args);
    }
}
