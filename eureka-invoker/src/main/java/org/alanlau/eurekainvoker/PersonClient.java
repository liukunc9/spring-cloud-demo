package org.alanlau.eurekainvoker;

import org.alanlau.eurekainvoker.pojo.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("eureka-provider") //声明调用的服务名称
public interface PersonClient {
    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    String hello();

    @RequestMapping(value = "/person/{personId}", method = RequestMethod.GET)
    Person getPerson(@PathVariable("personId") Integer personId);
}
