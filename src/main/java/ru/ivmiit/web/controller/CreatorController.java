package ru.ivmiit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.ivmiit.web.forms.BookCategoryForm;
import ru.ivmiit.web.forms.BookForm;
import ru.ivmiit.web.forms.PublisherForm;
import ru.ivmiit.web.model.OrderStatus;
import ru.ivmiit.web.service.*;
import ru.ivmiit.web.validators.BookCategoryFormValidator;
import ru.ivmiit.web.validators.BookFormValidator;
import ru.ivmiit.web.validators.PublisherFormValidator;

import javax.validation.Valid;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private OrderService orderService;

    @Autowired
    private BookCategoryFormValidator bookCategoryFormValidator;

    @Autowired
    private PublisherFormValidator publisherFormValidator;

    @Autowired
    private BookFormValidator bookFormValidator;

    @InitBinder("bookCategoryForm")
    public void initCategoryValidator(WebDataBinder binder) {
        binder.addValidators(bookCategoryFormValidator);
    }

    @InitBinder("publisherForm")
    public void initPublisherValidator(WebDataBinder binder) {
        binder.addValidators(publisherFormValidator);
    }

    @InitBinder("bookForm")
    public void initBookValidator(WebDataBinder binder) {
        binder.addValidators(bookFormValidator);
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
        model.addAttribute("books", bookService.getBooksDto(currentPage));
        model.addAttribute("pageList", bookService.getPageList(currentPage));
        model.addAttribute("currentPage", currentPage);
        return "creator/book/all_books";
    }

    @GetMapping("/books/create")
    public String getBook(@ModelAttribute("model") ModelMap model, Authentication authentication,
                              @RequestParam("id") Optional<Long> categoryId) {
        authenticationService.putUserToModelIfExists(authentication, model);
        categoryId.ifPresent(id -> model.addAttribute("book", bookService.getBookDto(id)));
        model.addAttribute("categories", bookCategoryService.getAllCategories());
        model.addAttribute("publishers", publisherService.getAllCategories());
        return "creator/book/create_book";
    }

    @PostMapping("/books/create")
    public String createBook(@Valid @ModelAttribute("bookForm") BookForm bookForm,
                                 BindingResult errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            attributes.addFlashAttribute("errors", errors.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList()));
            return "redirect:create";
        }else  {
            bookService.save(bookForm);
            attributes.addFlashAttribute("success", "Успешно!");
            return "redirect:create";
        }
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

    @GetMapping("/orders/all")
    public String getOrdersPage(@ModelAttribute("model") ModelMap model, Authentication authentication,
                                   @RequestParam("page") Optional<Integer> page) {
        authenticationService.putUserToModelIfExists(authentication, model);
        int currentPage = page.orElse(0);
        model.addAttribute("orders", orderService.getAllOrders(currentPage));
        model.addAttribute("pageList", orderService.getAllPageList(currentPage));
        model.addAttribute("currentPage", currentPage);
        return "creator/order/all_orders";
    }

    @GetMapping("/orders/change")
    public String changeOrderStatus(@RequestParam("status")String orderStatus,
                                    @RequestParam("id") Long orderId,
                                    @RequestParam("redirectPage") Long page) {
        orderService.changeStatus(orderId, OrderStatus.valueOf(orderStatus));
        return "redirect:all?page=" + page;
    }

}
