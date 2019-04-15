package ru.ivmiit.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ivmiit.web.forms.BookForm;
import ru.ivmiit.web.forms.OrderBook;
import ru.ivmiit.web.forms.OrderForm;

import java.util.Optional;

@Component
public class OrderFormValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.getName().equals(OrderForm.class.getName());
    }

    @Override
    public void validate(Object target, Errors errors) {
        OrderForm form = (OrderForm) target;

        if(form.getBooks() == null || form.getOrderBooksList().size() == 0){
            errors.reject("books", "Выберите минимум 1 товар");
        }

        Optional<OrderBook> book = form.getOrderBooksList().stream().filter(e -> e.getCount() <= 0).findFirst();
        if(book.isPresent()){
            errors.reject("book", "Количество товаров должно быть больше 0");
        }
    }
}
