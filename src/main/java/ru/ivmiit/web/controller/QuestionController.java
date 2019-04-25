package ru.ivmiit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.ivmiit.web.model.User;
import ru.ivmiit.web.service.AuthenticationService;
import ru.ivmiit.web.service.EmailService;

@Controller
public class QuestionController {
    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private EmailService emailService;

    @Value("${email.name}")
    private String emailName;

    @GetMapping("/question")
    public String getQuestionPage(@ModelAttribute("model") ModelMap model, Authentication authentication){
        authenticationService.putUserToModelIfExists(authentication, model);
        return "common/question";
    }

    @PostMapping("/question")
    public String sendQuestion(@RequestParam("text")String text, RedirectAttributes redirectAttributes){
        User user = authenticationService.getCurrentUser();
        emailService.sendMail(text, "Вопрос от пользователя " + user.getLogin() + " (" + user.getEmail() + ")", emailName);
        redirectAttributes.addFlashAttribute("success", "Ваш вопрос отправлен! Совсем скоро мы вам ответим");
        return "redirect:/question";
    }

}
