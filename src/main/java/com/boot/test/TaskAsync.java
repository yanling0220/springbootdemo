package com.boot.test;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author yanling
 * @time 2018-03-06-16:01
 */
@Component
public class TaskAsync {
    //定义一个随机对象.
    public static Random random =new Random();

    @Async
    public void taskAsyncOne() throws InterruptedException {
        System.err.println("taskAsyncOne Start");
        Long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        Long end = System.currentTimeMillis();
        System.err.println("taskAsyncOne 耗时： " +(end -start) + "毫秒 !");
    }

    @Async
    public void taskAsyncTwo() throws InterruptedException {
        System.err.println("taskAsyncTwo Start");
        Long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        Long end = System.currentTimeMillis();
        System.err.println("taskAsyncTwo 耗时： " +(end -start) + "毫秒 !");
    }
    @Async
    public void taskAsyncThree() throws InterruptedException {
        System.err.println("taskAsyncThree Start");
        Long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        Long end = System.currentTimeMillis();
        System.err.println("taskAsyncThree 耗时： " +(end -start) + "毫秒 !");
    }
}
