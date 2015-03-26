package com.sample;

import com.netflix.loadbalancer.IRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SampleController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/customers-ping")
    public void pingCustomers() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("customers");
        System.out.println("Chose customers service instance " + serviceInstance.getHost() + ":" + serviceInstance.getPort());

        // Do request here, etc.
    }

    @RequestMapping("/stores-ping")
    public void pingStores() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("stores");
        System.out.println("Chose stores service instance " + serviceInstance.getHost() + ":" + serviceInstance.getPort());

        // Do request here, etc.
    }
}
