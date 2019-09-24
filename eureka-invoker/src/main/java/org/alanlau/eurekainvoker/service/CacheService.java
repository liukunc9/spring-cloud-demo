package org.alanlau.eurekainvoker.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.alanlau.eurekainvoker.pojo.Person;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
    @CacheResult
    @HystrixCommand
    public Person getPerson(Integer id) {
        System.out.println("执行getPerson 方法");
        Person p = new Person();
        p.setId(id);
        p.setName("angus");
        return p;
    }

    @CacheResult
    @HystrixCommand(commandKey = "cache-key1")
    public String cacheMethod(Integer id) {
        System.out.println("执行了缓存方法" + id);
        return "hello";
    }

    @CacheRemove(commandKey = "cache-key1")
    @HystrixCommand
    public String removeMethod() {
        System.out.println("移除了key 为 cache-key1 的缓存");
        return "remove";
    }
}
