package ru.ivmiit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.ivmiit.web.service.AuthenticationService;
import ru.ivmiit.web.service.BookService;

import java.util.Optional;

@Controller
@RequestMapping("/creator")
public class CreatorController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private BookService bookService;

    @GetMapping("/books/all")
    public String getBooksPage(@ModelAttribute("model") ModelMap model, Authentication authentication, @RequestParam("page") Optional<Integer> page) {
        authenticationService.putUserToModelIfExists(authentication, model);
        int currentPage = page.orElse(0);
        model.addAttribute("books", bookService.getBooks(currentPage));
        model.addAttribute("pageList", bookService.getPageList(currentPage));
        model.addAttribute("currentPage", currentPage);
        return "creator/books/all_books";
    }

//    @PostMapping("create")
//    public String createTask(@Valid @ModelAttribute("taskForm") TaskForm taskForm, BindingResult errors, RedirectAttributes attributes) {
//        if (errors.hasErrors()) {
//            List<String> errorList = errors.getAllErrors()
//                    .stream()
//                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
//                    .collect(Collectors.toList());
//            attributes.addFlashAttribute("errors", errorList);
//            return "redirect:create";
//        }
//        taskService.save(taskForm);
//
//        attributes.addFlashAttribute("info", "Успешно!");
//        return "redirect:create";
//    }
}
