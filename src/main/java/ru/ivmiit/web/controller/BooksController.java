package ru.ivmiit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.ivmiit.web.model.BookCategory;
import ru.ivmiit.web.repository.BookCategoryRepository;
import ru.ivmiit.web.service.AuthenticationService;
import ru.ivmiit.web.service.BookCategoryService;
import ru.ivmiit.web.service.BookService;

import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private BookCategoryService bookCategoryService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @GetMapping("/all")
    public String getBooksPage(@ModelAttribute("model") ModelMap model,
                               Authentication authentication,
                               @RequestParam("page") Optional<Integer> page,
                               @RequestParam(value = "query", required = false) String query,
                               @RequestParam(value = "categoryId", required = false) Long id) {
        authenticationService.putUserToModelIfExists(authentication, model);
        int currentPage = page.orElse(0);
        BookCategory category = id == null ? null : bookCategoryRepository.findById(id).orElse(null);
        model.addAttribute("pageList", bookService.getPageList(currentPage, query, category));
        model.addAttribute("books", bookService.getBooksDto(currentPage, query, category));
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("categories", bookCategoryService.getAllCategories());
        return "books/all_books";
    }

    @GetMapping("/show/{id}")
    public String getBooksPage(@ModelAttribute("model") ModelMap model, Authentication authentication, @PathVariable("id") Long bookId) {
        authenticationService.putUserToModelIfExists(authentication, model);
        model.addAttribute("book", bookService.getBookDto(bookId));
        return "books/book_page";
    }

    @PostMapping("/comment/{id}")
    public String sendComment(@PathVariable("id") Long bookId, @RequestParam("text") String text,
                              RedirectAttributes redirectAttributes) {
        if (text.length() < 25 || text.length() > 2048) {
            redirectAttributes.addFlashAttribute("error", "Длинна комментария от 25 до 2048 символов");
        }else{
            bookService.sendComment(bookId, text);
        }
        return "redirect:/books/show/" + bookId;    }
}
