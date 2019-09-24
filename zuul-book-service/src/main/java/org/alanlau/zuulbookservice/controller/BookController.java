package org.alanlau.zuulbookservice.controller;

import org.alanlau.zuulbookservice.pojo.Book;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book findBook(@PathVariable Integer bookId){
        return new Book(bookId,"Workflow讲义","杨恩雄");
    }
}