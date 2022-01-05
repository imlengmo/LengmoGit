package com.qinguang.until.test;

import com.qinguang.until.single.Singleton2;

/**
 * @author zam
 * @date 2021/12/25 -18:07
 */
public class TestSingleton2 {
    public static void main(String[] args) {
        Singleton2 s = Singleton2.INSTANCE;
        System.out.println(s);
    }
}
