package ru.ivmiit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.ivmiit.web.forms.UserRegistrationForm;
import ru.ivmiit.web.forms.UserRestorePasswordForm;
import ru.ivmiit.web.model.User;
import ru.ivmiit.web.repository.UserRepository;
import ru.ivmiit.web.security.details.State;
import ru.ivmiit.web.service.AuthenticationService;
import ru.ivmiit.web.service.RegistrationService;
import ru.ivmiit.web.validators.UserRegistrationFormValidator;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

/**
 * 10.11.2017
 * RegistrationController
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserRegistrationFormValidator userRegistrationFormValidator;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @InitBinder("userForm")
    public void initUserFormValidator(WebDataBinder binder) {
        binder.addValidators(userRegistrationFormValidator);
    }

    @GetMapping(value = "/confirm/{file-name}")
    public String confirmEmail(@PathVariable("file-name") String fileName, RedirectAttributes attributes) {
        Optional<User> optionalUser = userRepository.findByUuid(UUID.fromString(fileName));
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setState(State.CONFIRMED);
            userRepository.save(user);
            attributes.addFlashAttribute("success", "Пользователь подтверждён");
        }
        return "redirect:/login";
    }

    @PostMapping(value = "/sign-up")
    public String signUp(@Valid @ModelAttribute("userForm") UserRegistrationForm userRegistrationForm,
                         BindingResult errors, RedirectAttributes attributes, @ModelAttribute("model") ModelMap model) {
        if (errors.hasErrors()) {
            attributes.addFlashAttribute("error", errors.getAllErrors().get(0).getDefaultMessage());
            return "redirect:/sign-up";
        }
        registrationService.register(userRegistrationForm);
        authenticationService.putUserToModelIfExists(null, model);
        return "success_registration";
    }

    @GetMapping(value = "/sign-up")
    public String getSignUpPage(@ModelAttribute("model") ModelMap model) {
        authenticationService.putUserToModelIfExists(null, model);
        return "sign_up";
    }


    @GetMapping("/restore")
    public String restorePasswordPage(@ModelAttribute("model") ModelMap model) {
        authenticationService.putUserToModelIfExists(null, model);
        return "restore/restore";
    }

    @PostMapping("/restore")
    public String restorePassword(RedirectAttributes attributes, @RequestParam("login") String login) {
        try {
            registrationService.sendRestoreCode(login);
            attributes.addFlashAttribute("success", "Успешно!");
        } catch (IllegalArgumentException e) {
            attributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:restore";
    }

    @GetMapping("/restore/{uuid}")
    public String restorePasswordUuidPage(@ModelAttribute("model") ModelMap model,
                                          @PathVariable("uuid") String uuid) {
        if (!userRepository.findByUuid(UUID.fromString(uuid)).isPresent()) {
            return "redirect:/";
        }

        authenticationService.putUserToModelIfExists(null, model);
        model.addAttribute("uuid", uuid);
        return "restore/restore_create_password";
    }

    @PostMapping("/restore/{uuid}")
    public String restorePasswordUuidPage(UserRestorePasswordForm restoreForm,
                                          @PathVariable("uuid") String uuid,
                                          @ModelAttribute("model") ModelMap model,
                                          RedirectAttributes attributes) {
        if (!userRepository.findByUuid(UUID.fromString(uuid)).isPresent()) {
            return "redirect:/";
        }

        if (!restoreForm.getPassword().equals(restoreForm.getPasswordRepeat())) {
            attributes.addFlashAttribute("error", "Пароли не совпадают");
            return "redirect:/restore/" + uuid;
        }

        registrationService.restorePassword(UUID.fromString(uuid), restoreForm.getPassword());
        attributes.addFlashAttribute("success", "Код отправлен на почту");
        return "redirect:/login";
    }

}
