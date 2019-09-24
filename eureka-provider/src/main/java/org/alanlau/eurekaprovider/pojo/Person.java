package org.alanlau.eurekaprovider.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private Integer id;
    private String name;
    private Integer age;
    private String message;

    public Person(Integer id, String name, Integer age, String message) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.message = message;
    }
}
