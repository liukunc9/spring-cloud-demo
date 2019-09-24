package org.alanlau.eurekainvoker.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.alanlau.eurekainvoker.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getPersonFallback")
    public Person getPerson(Integer id) {
        //使用RestTemplate调用Eureka 服务
        Person p = restTemplate.getForObject("http://eureka-provider/person/{personId}", Person.class, id);
        return p;
    }

    /**
     * 回退方法，返回一个默认的Person
     */
    public Person getPersonFallback(Integer id) {
        Person p = new Person();
        p.setId(0);
        p.setName("Crazyit");
        p.setAge(-1);
        p.setMessage("request error");
        return p;
    }
}
