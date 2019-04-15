package ru.ivmiit.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ivmiit.web.forms.BookCategoryForm;
import ru.ivmiit.web.forms.BookForm;

@Component
public class BookFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(BookForm.class.getName());
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookForm form = (BookForm) target;

        if (form.getName().length() < 3 || form.getName().length() > 255) {
            errors.reject("name", "Название должно содержать от 3 до 255 символов");
        }

        if (form.getPageCount() == null || form.getPageCount() <= 0) {
            errors.reject("pageCount", "Количество страниц должно быть больше 0 ");
        }

        if (form.getTitlePage() == null || form.getTitlePage().isEmpty()) {
            errors.reject("titlePage", "Выберите обложку");
        }

        if (form.getCategoryId() == 0 || form.getCategoryId() == 0) {
            errors.reject("category", "Заполните категорию");
        }

        if (form.getAuthor().length() < 3 || form.getAuthor().length() > 255) {
            errors.reject("author", "Название автора должно содержать от 3 до 255 символов");
        }

        if (form.getPublisherId() == 0 || form.getPublisherId() == 0) {
            errors.reject("publisher", "Заполните издателя");
        }

        if (form.getDescription().length() <= 0 || form.getDescription().length() > 2048) {
            errors.reject("description", "Описание должно содержать от 3 до 255 символов");
        }

        if (form.getPrice() <= 0) {
            errors.reject("price", "Цена должна быть больше 0");
        }

        if (form.getCount() <= 0) {
            errors.reject("price", "Количество должно быть больше 0");
        }

        if (form.getRating() <= 0) {
            errors.reject("price", "Рейтинг должен быть больше 0");
        }
    }
}
