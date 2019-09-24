package org.alanlau.zuulsaleservice.controller;

import org.alanlau.zuulsaleservice.feign.BookService;
import org.alanlau.zuulsaleservice.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaleController {
    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/sale-book/{bookId}", method = RequestMethod.GET)
    public String saleBook(@PathVariable Integer bookId){
        Book book=bookService.getBook(bookId);
        System.out.println("销售模块处理销售，要销售的图书id: "+book.getId()+", 书名: "+book.getName());

        //销售成功
        return "SUCCESS";
    }

}
