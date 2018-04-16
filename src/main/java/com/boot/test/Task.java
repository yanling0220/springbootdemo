package com.boot.test;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author yanling
 * @time 2018-03-06-15:53
 */
@Component
public class Task {
    //定义一个随机对象.
    public static Random random =new Random();

    public void taskOne() throws InterruptedException {
        System.err.println("taskOne Start");
        Long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        Long end = System.currentTimeMillis();
        System.err.println("taskOne 耗时： " +(end -start) + "毫秒 !");
    }


    public void taskTwo() throws InterruptedException {
        System.err.println("taskTwo Start");
        Long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        Long end = System.currentTimeMillis();
        System.err.println("taskTwo 耗时： " +(end -start) + "毫秒 !");
    }

    public void taskThree() throws InterruptedException {
        System.err.println("taskThree Start");
        Long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        Long end = System.currentTimeMillis();
        System.err.println("taskThree 耗时： " +(end -start) + "毫秒 !");
    }
}
