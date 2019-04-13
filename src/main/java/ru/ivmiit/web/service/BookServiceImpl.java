package ru.ivmiit.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivmiit.web.model.Book;
import ru.ivmiit.web.repository.BookCategoryRepository;
import ru.ivmiit.web.repository.BookRepository;
import ru.ivmiit.web.utils.TaskUtils;

import java.util.List;


@Service
public class BookServiceImpl implements BookService {

    static Logger logger = LoggerFactory.getLogger(BookService.class.getName());

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    private static int paginationPagesCount = 5;

    private static int defaultElementsInPage = 15;

    @Override
    @Transactional
    public List<Book> getBooks(int page) {
        return getBooks(page, defaultElementsInPage);
    }

    @Override
    @Transactional
    public List<Book> getBooks(int page, int count) {
        return bookRepository.findAll(PageRequest.of(page, count)).getContent();
    }

    @Override
    @Transactional
    public List<Integer> getPageList(int currentPage) {
        return getPageList(currentPage, defaultElementsInPage);
    }

    @Override
    public List<Integer> getPageList(int currentPage, int elementsInPage) {
        int pageCount = (int) Math.ceil(((double) bookRepository.count()) / elementsInPage);
        int maxPage = pageCount - 1;
        return TaskUtils.getPageList(currentPage, paginationPagesCount, maxPage);
    }

    @Override
    @Transactional
    public Book getTask(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not fount"));
    }

}
