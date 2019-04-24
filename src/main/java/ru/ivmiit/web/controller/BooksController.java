package ru.ivmiit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.ivmiit.web.service.AuthenticationService;
import ru.ivmiit.web.service.BookService;
import ru.ivmiit.web.transfer.BookDto;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public String getBooksPage(@ModelAttribute("model") ModelMap model, Authentication authentication, @RequestParam("page") Optional<Integer> page) {
        authenticationService.putUserToModelIfExists(authentication, model);
        int currentPage = page.orElse(0);
        model.addAttribute("pageList", bookService.getPageList(currentPage));
        model.addAttribute("books", bookService.getBooksDto(currentPage));
        model.addAttribute("currentPage", currentPage);
        return "books/all_books";
    }

    @GetMapping("/show/{id}")
    public String getBooksPage(@ModelAttribute("model") ModelMap model, Authentication authentication, @PathVariable("id")Long bookId) {
        authenticationService.putUserToModelIfExists(authentication, model);
        model.addAttribute("book", bookService.getBookDto(bookId));
        return "books/book_page";
    }
}
