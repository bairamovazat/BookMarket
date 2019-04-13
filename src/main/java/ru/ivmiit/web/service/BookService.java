package ru.ivmiit.web.service;

import org.springframework.transaction.annotation.Transactional;
import ru.ivmiit.web.model.Book;

import java.util.List;

public interface BookService {

    @Transactional
    List<Book> getBooks(int page);

    @Transactional
    List<Book> getBooks(int page, int count);

    @Transactional
    List<Integer> getPageList(int currentPage);

    List<Integer> getPageList(int currentPage, int elementsInPage);

    @Transactional
    Book getTask(Long id);
}
