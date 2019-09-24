package org.alanlau.eurekainvoker.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "eureka-provider", fallback = HelloClient.HelloClientFallback.class)
public interface HelloClient {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello();

    @Component
    static class HelloClientFallback implements HelloClient {

        @Override
        public String hello() {
            System.out.println("hello 方法的回退");
            return "error hello";
        }
    }
}
