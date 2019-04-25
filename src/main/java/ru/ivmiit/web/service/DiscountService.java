package ru.ivmiit.web.service;

import ru.ivmiit.web.forms.DiscountForm;
import ru.ivmiit.web.model.Discount;

import javax.transaction.Transactional;
import java.util.List;

public interface DiscountService {
    @Transactional
    List<Discount> getDiscounts(int page);

    @Transactional
    List<Discount> getDiscounts(int page, int count);

    @Transactional
    List<Integer> getPageList(int currentPage);

    List<Integer> getPageList(int currentPage, int elementsInPage);

    @Transactional
    Discount getDiscount(Long id);

    @Transactional
    void save(DiscountForm discountForm);

    void delete(Long bookId);

    @Transactional
    List<Discount> getAllDiscount();
}
