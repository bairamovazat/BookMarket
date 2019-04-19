package ru.ivmiit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.ivmiit.web.forms.BookForm;
import ru.ivmiit.web.service.BookService;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private BookService bookService;

//    @PostMapping("/books/create")
//    public Object createBook(BookForm bookForm, @RequestParam("token") String token) {
//        if(!token.equals("12345677")){
//            return ResponseEntity.badRequest().body("Invalid Token");
//        }
//        try {
//            bookService.save(bookForm);
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//        return "OK";
//    }
}
