package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author zam
 * @date 2022/1/4 -16:11
 */
@Component//必须加 //必须加 //必须加
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80--paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80--paymentInfo_TimeOut";
    }
}
