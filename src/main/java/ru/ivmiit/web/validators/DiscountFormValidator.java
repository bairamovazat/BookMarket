package ru.ivmiit.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ivmiit.web.forms.DiscountForm;

@Component
public class DiscountFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(DiscountForm.class.getName());
    }

    @Override
    public void validate(Object target, Errors errors) {
        DiscountForm form = (DiscountForm) target;

        if (form.getCode() == null || (form.getCode().length() < 3 || form.getCode().length() > 255)) {
            errors.reject("name", "Код должен содержать от 3 до 255 символов");
        }

        if (form.getSalePercent() == null || (form.getSalePercent() < 1 || form.getSalePercent() > 99)) {
            errors.reject("sale", "Скидка должна быть от 1 до 99 процентов");
        }

    }
}
