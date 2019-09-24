package org.alanlau.eurekaprovider.controller;

import org.alanlau.eurekaprovider.pojo.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ProviderController {
    @RequestMapping(value = "/person/{personId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findPerson(@PathVariable("personId") Integer personId, HttpServletRequest request) {
        Person person = new Person(personId, "AlanLau", 25, request.getRequestURL().toString());
        return person;
    }

    @GetMapping("/hello")
    public String sayHello() throws InterruptedException {
        Thread.sleep(800);
        return "Hello World!";
    }
}
