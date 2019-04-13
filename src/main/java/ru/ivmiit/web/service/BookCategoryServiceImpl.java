package ru.ivmiit.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivmiit.web.forms.BookCategoryForm;
import ru.ivmiit.web.model.BookCategory;
import ru.ivmiit.web.repository.BookCategoryRepository;
import ru.ivmiit.web.repository.BookRepository;
import ru.ivmiit.web.utils.TaskUtils;

import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {


    static Logger logger = LoggerFactory.getLogger(BookCategoryServiceImpl.class.getName());

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    private static int paginationPagesCount = 5;

    private static int defaultElementsInPage = 15;

    @Override
    @Transactional
    public List<BookCategory> getCategories(int page) {
        return getCategories(page, defaultElementsInPage);
    }


    @Override
    @Transactional
    public List<BookCategory> getCategories(int page, int count) {
        return bookCategoryRepository.findAll(PageRequest.of(page, count)).getContent();
    }

    @Override
    @Transactional
    public List<Integer> getPageList(int currentPage) {
        return getPageList(currentPage, defaultElementsInPage);
    }

    @Override
    public List<Integer> getPageList(int currentPage, int elementsInPage) {
        int pageCount = (int) Math.ceil(((double) bookCategoryRepository.count()) / elementsInPage);
        int maxPage = pageCount - 1;
        return TaskUtils.getPageList(currentPage, paginationPagesCount, maxPage);
    }

    @Override
    @Transactional
    public BookCategory getCategory(Long id) {
        return bookCategoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book category not fount"));
    }

    @Override
    @Transactional
    public void save(BookCategoryForm bookCategoryForm){
        BookCategory bookCategory;
        if(bookCategoryForm.getId() != null){
            bookCategory = bookCategoryRepository.findById(bookCategoryForm.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Book category not found"));

        }else {
            bookCategory = new BookCategory();
        }

        bookCategory.setName(bookCategoryForm.getName());
        bookCategoryRepository.save(bookCategory);
    }

}
