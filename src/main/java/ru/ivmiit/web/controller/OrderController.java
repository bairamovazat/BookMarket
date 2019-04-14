package ru.ivmiit.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.ivmiit.web.forms.OrderForm;
import ru.ivmiit.web.service.AuthenticationService;
import ru.ivmiit.web.service.OrderService;
import ru.ivmiit.web.validators.OrderFormValidator;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private OrderFormValidator orderFormValidator;

    @Autowired
    private OrderService orderService;

    @InitBinder("orderForm")
    public void initBookValidator(WebDataBinder binder) {
        binder.addValidators(orderFormValidator);
    }


    @GetMapping("/create")
    public String getMainPage(@ModelAttribute("model") ModelMap model, Authentication authentication){
        authenticationService.putUserToModelIfExists(authentication, model);
        return "basket";
    }

    @PostMapping("/create")
    public String createOrder(@Valid @ModelAttribute("orderForm") OrderForm orderForm,
                                  BindingResult errors, RedirectAttributes attributes) {
        if (errors.hasErrors()) {
            attributes.addFlashAttribute("error", errors.getAllErrors().get(0).getDefaultMessage());
            return "redirect:/order/create";
        }else  {
            orderService.save(orderForm);
            attributes.addFlashAttribute("success", "Успешно!");
            return "redirect:/order/create";
        }
    }

    @GetMapping("/all")
    public String getAllOrders(@ModelAttribute("model") ModelMap model, Authentication authentication,
                               @RequestParam("page") Optional<Integer> page){
        authenticationService.putUserToModelIfExists(authentication, model);
        int currentPage = page.orElse(0);
        model.addAttribute("orders", orderService.getCurrentUserOrders(currentPage));
        model.addAttribute("pageList", orderService.getCurrentUserPageList(currentPage));
        model.addAttribute("currentPage", currentPage);
        return "all_orders";
    }

}
