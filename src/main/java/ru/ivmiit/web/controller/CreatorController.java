package ru.ivmiit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.ivmiit.web.forms.BookCategoryForm;
import ru.ivmiit.web.forms.PublisherForm;
import ru.ivmiit.web.service.AuthenticationService;
import ru.ivmiit.web.service.BookCategoryService;
import ru.ivmiit.web.service.BookService;
import ru.ivmiit.web.service.PublisherService;
import ru.ivmiit.web.validators.BookCategoryFormValidator;
import ru.ivmiit.web.validators.PublisherFormValidator;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/creator")
public class CreatorController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookCategoryService bookCategoryService;

    @Autowired
    private PublisherService publisherService;

    @Autowired
    private BookCategoryFormValidator bookCategoryFormValidator;

    @Autowired
    private PublisherFormValidator publisherFormValidator;

    @InitBinder("bookCategoryForm")
    public void initCategoryValidator(WebDataBinder binder) {
        binder.addValidators(bookCategoryFormValidator);
    }

    @InitBinder("publisherForm")
    public void initPublisherValidator(WebDataBinder binder) {
        binder.addValidators(publisherFormValidator);
    }

    @GetMapping
    public String getMainPage(@ModelAttribute("model") ModelMap model, Authentication authentication){
        authenticationService.putUserToModelIfExists(authentication, model);
        return "creator/main_page";
    }

    @GetMapping("/books/all")
    public String getBooksPage(@ModelAttribute("model") ModelMap model, Authentication authentication,
                               @RequestParam("page") Optional<Integer> page) {
        authenticationService.putUserToModelIfExists(authentication, model);
        int currentPage = page.orElse(0);
        model.addAttribute("books", bookService.getBooks(currentPage));
        model.addAttribute("pageList", bookService.getPageList(currentPage));
        model.addAttribute("currentPage", currentPage);
        return "creator/book/all_books";
    }

    @GetMapping("/categories/all")
    public String getCategoriesPage(@ModelAttribute("model") ModelMap model, Authentication authentication,
                                    @RequestParam("page") Optional<Integer> page) {
        authenticationService.putUserToModelIfExists(authentication, model);
        int currentPage = page.orElse(0);
        model.addAttribute("categories", bookCategoryService.getCategories(currentPage));
        model.addAttribute("pageList", bookCategoryService.getPageList(currentPage));
        model.addAttribute("currentPage", currentPage);
        return "creator/category/all_category";
    }

    @GetMapping("/categories/create")
    public String getCategory(@ModelAttribute("model") ModelMap model, Authentication authentication,
                              @RequestParam("id") Optional<Long> categoryId) {
        authenticationService.putUserToModelIfExists(authentication, model);
        categoryId.ifPresent(id -> model.addAttribute("category", bookCategoryService.getCategory(id)));
        return "creator/category/create_category";
    }

    @PostMapping("/categories/create")
    public String createCategory(@Valid @ModelAttribute("bookCategoryForm") BookCategoryForm bookCategoryForm,
                                 BindingResult errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            attributes.addFlashAttribute("error", errors.getAllErrors().get(0).getDefaultMessage());
            return "redirect:create";
        }else  {
            bookCategoryService.save(bookCategoryForm);
            attributes.addFlashAttribute("success", "Успешно!");
            return "redirect:create";
        }
    }

    @GetMapping("/publishers/all")
    public String getPublisherPage(@ModelAttribute("model") ModelMap model, Authentication authentication,
                                    @RequestParam("page") Optional<Integer> page) {
        authenticationService.putUserToModelIfExists(authentication, model);
        int currentPage = page.orElse(0);
        model.addAttribute("publishers", publisherService.getPublishers(currentPage));
        model.addAttribute("pageList", publisherService.getPageList(currentPage));
        model.addAttribute("currentPage", currentPage);
        return "creator/publisher/all_publishers";
    }

    @GetMapping("/publishers/create")
    public String getPublisher(@ModelAttribute("model") ModelMap model, Authentication authentication,
                              @RequestParam("id") Optional<Long> categoryId) {
        authenticationService.putUserToModelIfExists(authentication, model);
        categoryId.ifPresent(id -> model.addAttribute("publisher", publisherService.getPublisher(id)));
        return "creator/publisher/create_publisher";
    }

    @PostMapping("/publishers/create")
    public String createPublisher(@Valid @ModelAttribute("publisherForm") PublisherForm publisherForm,
                                 BindingResult errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            attributes.addFlashAttribute("error", errors.getAllErrors().get(0).getDefaultMessage());
            return "redirect:create";
        }else  {
            publisherService.save(publisherForm);
            attributes.addFlashAttribute("success", "Успешно!");
            return "redirect:create";
        }
    }

}
