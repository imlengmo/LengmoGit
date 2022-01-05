package com.atguigu.test;

import java.time.ZonedDateTime;

/**
 * @author zam
 * @date 2022/1/5 -10:47
 */
public class ZonedDateTimeDemo
{
    public static void main(String[] args)
    {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
//        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York")); // 用指定时区获取当前时间
//        System.out.println(zny);
    }
}
