package ru.ivmiit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.ivmiit.web.forms.BookForm;
import ru.ivmiit.web.forms.UserChangePasswordForm;
import ru.ivmiit.web.service.AuthenticationService;
import ru.ivmiit.web.service.RegistrationService;
import ru.ivmiit.web.validators.UserChangePasswordFormValidator;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserChangePasswordFormValidator userChangePasswordFormValidator;

    @InitBinder("changePasswordForm")
    public void initDiscountForm(WebDataBinder binder) {
        binder.addValidators(userChangePasswordFormValidator);
    }

    @GetMapping
    public String getProfilePage(Authentication authentication, @ModelAttribute("model") ModelMap model) {
        authenticationService.putUserToModelIfExists(authentication, model);
        return "profile/profile";
    }

    @PostMapping("/change/password")
    public String changePassword(@Valid @ModelAttribute("changePasswordForm") UserChangePasswordForm changePasswordForm,
                                 BindingResult errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            attributes.addFlashAttribute("errors", errors.getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList()));
        }else{
            registrationService.changeUserPassword(authenticationService.getCurrentUser(), changePasswordForm.getPassword());
            attributes.addFlashAttribute("success", "Успешно");
        }
        return "redirect:/profile";
    }
    @PostMapping("/change/email")
    public String changeEmail(@RequestParam("newEmail") String email, RedirectAttributes attributes) {
        if (email.length() < 5 || email.length() > 255) {
            attributes.addFlashAttribute("error", "Укажите верную почту");
        }else{
            registrationService.changeUserEmail(authenticationService.getCurrentUser(), email);
            attributes.addFlashAttribute("success", "Успешно");
        }
        return "redirect:/profile";
    }
}
