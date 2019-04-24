package ru.ivmiit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.ivmiit.web.model.User;
import ru.ivmiit.web.security.details.Role;
import ru.ivmiit.web.service.AuthenticationService;
import ru.ivmiit.web.service.BookService;

@Controller
public class MainController {


    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String root(Authentication authentication, @ModelAttribute("model") ModelMap model) {
        authenticationService.putUserToModelIfExists(authentication, model);
        model.addAttribute("editorChoseBooks", bookService.getEditorChoseBooks());
        model.addAttribute("saleBooks", bookService.getSaleBooks());
        model.addAttribute("dayBooks", bookService.getDayBooks());
        model.addAttribute("fictionBooks", bookService.getFictionBooks());
        return "common/main";
    }

}
