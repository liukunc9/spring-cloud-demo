package org.alanlau.zuulbookservice.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private Integer id;
    private String name;
    private String author;

    public Book(Integer id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
}
