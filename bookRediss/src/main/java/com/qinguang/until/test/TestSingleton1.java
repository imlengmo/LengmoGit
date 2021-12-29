package com.qinguang.until.test;

import com.qinguang.until.single.Singleton1;

/**
 * @author zam
 * @date 2021/12/25 -17:55
 */
public class TestSingleton1 {

    public static void main(String[] args) {

        Singleton1 singleton1 = Singleton1.INSTANCE;
        System.out.println("test1==================" + singleton1);

    }


}


