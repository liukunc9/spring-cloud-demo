package org.alanlau.zuulsaleservice.feign;

import org.alanlau.zuulsaleservice.pojo.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("zuul-book-service")
public interface BookService {
    @RequestMapping(value = "/book/{bookId}", method = RequestMethod.GET)
    Book getBook(@PathVariable("bookId") Integer bookId);
}
