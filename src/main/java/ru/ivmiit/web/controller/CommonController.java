package ru.ivmiit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ivmiit.web.service.AuthenticationService;

@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/delivery")
    public String getDeliveryPage(@ModelAttribute("model") ModelMap model, Authentication authentication){
        authenticationService.putUserToModelIfExists(authentication, model);
        return "common/delivery";
    }
    @GetMapping("/contacts")
    public String getContactsPage(@ModelAttribute("model") ModelMap model, Authentication authentication){
        authenticationService.putUserToModelIfExists(authentication, model);
        return "common/contacts";
    }
    @GetMapping("/main")
    public String getMainPage(@ModelAttribute("model") ModelMap model, Authentication authentication){
        authenticationService.putUserToModelIfExists(authentication, model);
        return "common/main";
    }
}
