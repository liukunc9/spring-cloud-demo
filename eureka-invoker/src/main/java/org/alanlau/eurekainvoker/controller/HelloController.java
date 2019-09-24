package org.alanlau.eurekainvoker.controller;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;
import org.alanlau.eurekainvoker.feign.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloClient helloClient;

    @RequestMapping(value = "/feign/hello", method = RequestMethod.GET)
    public String feignHello() {
        //hello方法会超时
        String helloResult = helloClient.hello();
        //获取断路器
        HystrixCircuitBreaker breaker = HystrixCircuitBreaker.Factory.getInstance(HystrixCommandKey.Factory.asKey("HelloClient#hello()"));
        System.out.println("断路器状态: " + breaker.isOpen());
        return helloResult;
    }
}
