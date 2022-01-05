package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zam
 * @date 2022/1/3 -15:57
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZK80
{
    public static void main(String[] args)
    {
        SpringApplication.run(OrderZK80.class,args);
    }
}