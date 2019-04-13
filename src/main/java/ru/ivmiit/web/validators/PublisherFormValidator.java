package ru.ivmiit.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ivmiit.web.forms.BookCategoryForm;
import ru.ivmiit.web.forms.PublisherForm;

@Component
public class PublisherFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(PublisherForm.class.getName());
    }

    @Override
    public void validate(Object target, Errors errors) {
        PublisherForm form = (PublisherForm) target;

        if (form.getName().length() < 3 || form.getName().length() > 255) {
            errors.reject("name", "Название должно содержать от 3 до 255 символов");
        }
    }
}
