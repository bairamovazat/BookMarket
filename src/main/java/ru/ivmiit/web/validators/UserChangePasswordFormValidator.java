package ru.ivmiit.web.validators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.ivmiit.web.forms.UserChangePasswordForm;
import ru.ivmiit.web.forms.UserRegistrationForm;
import ru.ivmiit.web.model.User;
import ru.ivmiit.web.repository.UserRepository;
import ru.ivmiit.web.service.AuthenticationService;
import sun.security.util.Password;

import java.util.Optional;

@Component
public class UserChangePasswordFormValidator implements Validator {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(UserChangePasswordForm.class.getName());
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserChangePasswordForm form = (UserChangePasswordForm)target;

        User user = authenticationService.getCurrentUser();
        if(!passwordEncoder.matches(form.getCurrentPassword(), user.getHashPassword())){
            errors.reject("bad.password", "Неверный пароль!");
        }

        if(!form.getPassword().equals(form.getPasswordRepeat())){
            errors.reject("bad.passwordRepeat", "Пароли не совпадают");
        }
    }
}
