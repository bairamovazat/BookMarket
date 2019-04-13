package ru.ivmiit.web.service;

import org.springframework.transaction.annotation.Transactional;
import ru.ivmiit.web.forms.BookCategoryForm;
import ru.ivmiit.web.model.BookCategory;

import java.util.List;

public interface BookCategoryService {
    @Transactional
    List<BookCategory> getCategories(int page);

    @Transactional
    List<BookCategory> getCategories(int page, int count);

    @Transactional
    List<Integer> getPageList(int currentPage);

    List<Integer> getPageList(int currentPage, int elementsInPage);

    @Transactional
    BookCategory getCategory(Long id);

    @Transactional
    void save(BookCategoryForm bookCategoryForm);
}
