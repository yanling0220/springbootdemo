package com.boot.test;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yanling
 * @time 2018-02-01-17:31
 */
@Service
public class HelloService {
    public HelloService() {
        System.err.println("11111111111111111");
        System.err.println("2222222222222");
        System.err.println("3333333333333333");
        System.err.println("4444444444444444");
    }

    public static void main(String[] args) {
        Map<String, Object> map = new ConcurrentHashMap();
        map.put("yanling", "man");
        map.put("age", 22);
        map.size();
    }
}
