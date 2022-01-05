package com.atguigu.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zam
 * @date 2022/1/4 -14:50
 */
public interface PaymentService {

     String paymentInfo_OK(Integer id);

     String paymentInfo_TimeOut(Integer id);

     String paymentCircuitBreaker(@PathVariable("id") Integer id);

     String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id);
}
