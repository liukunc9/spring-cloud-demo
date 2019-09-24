package org.alanlau.eurekainvoker.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.alanlau.eurekainvoker.pojo.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@Service
public class CollapseService {
    //配置收集1秒内的请求
    @HystrixCollapser(batchMethod = "getPersons", collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "1000")
    })
    public Future<Person> getSinglePerson(Integer id) {
        System.out.println("执行单个获取的方法");
        return null;
    }

    //执行请求的命令，作用是将全部参数进行整理，然后调用外服服务
    @HystrixCommand
    public List<Person> getPersons(List<Integer> ids) {
        System.out.println("收集请求，参数数量： " + ids.size());
        List<Person> ps = new ArrayList<>();
        for (Integer id : ids) {
            Person p = new Person();
            p.setId(id);
            p.setName("crazyit");
            ps.add(p);
        }

        return ps;
    }
}
