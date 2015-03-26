package com.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "customers", configuration = CustomersRibbonConfiguration.class)
public class SampleApp {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleApp.class, args);
    }
}
