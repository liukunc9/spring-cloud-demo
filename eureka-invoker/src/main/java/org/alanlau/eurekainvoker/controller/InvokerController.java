package org.alanlau.eurekainvoker.controller;

import org.alanlau.eurekainvoker.pojo.Person;
import org.alanlau.eurekainvoker.service.CacheService;
import org.alanlau.eurekainvoker.service.CollapseService;
import org.alanlau.eurekainvoker.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class InvokerController {
    @Autowired
    private CacheService cacheService;
    @Autowired
    private PersonService personService;
    @Autowired
    private CollapseService collapseService;

    @RequestMapping(value = "/router/{personId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person router(@PathVariable Integer personId) {
        Person p = personService.getPerson(personId);

        return p;
    }

    @RequestMapping(value = "/cache1/{personId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person testCacheResult(@PathVariable Integer personId) {
        //调用多次服务
        for (int i = 0; i < 3; i++) {
            Person p = cacheService.getPerson(personId);
            System.out.println("控制器调用服务 " + i);
        }
        return new Person();
    }

    @RequestMapping(value = "/cache/hello/{testId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String useCache(@PathVariable Integer testId) {
        //调用多次服务
        for (int i = 0; i < 6; i++) {
            if (i == 3) {
                cacheService.removeMethod();
            }
            cacheService.cacheMethod(testId);
            System.out.println("调用服务 " + i);
        }

        return "{status:'success'}";
    }

    @RequestMapping(value = "/collapse", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String testCollapse() throws ExecutionException, InterruptedException {
        //连续执行3次请求
        Future<Person> f1 = collapseService.getSinglePerson(1);
        Future<Person> f2 = collapseService.getSinglePerson(2);
        Future<Person> f3 = collapseService.getSinglePerson(3);

        Person p1 = f1.get();
        Person p2 = f2.get();
        Person p3 = f3.get();

        System.out.println(p1.getId() + "----" + p1.getName());
        System.out.println(p2.getId() + "----" + p2.getName());
        System.out.println(p3.getId() + "----" + p3.getName());

        return "";
    }
}
