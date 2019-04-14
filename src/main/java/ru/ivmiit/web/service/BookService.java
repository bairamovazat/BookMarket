package ru.ivmiit.web.service;

import org.springframework.transaction.annotation.Transactional;
import ru.ivmiit.web.forms.BookForm;
import ru.ivmiit.web.model.Book;
import ru.ivmiit.web.model.BookCategory;
import ru.ivmiit.web.transfer.BookDto;

import java.util.List;

public interface BookService {

    @Transactional
    List<Book> getBooks(int page);

    @Transactional
    List<Book> getBooks(int page, int count);

    @Transactional
    List<BookDto> getBooksDto(int page);

    @Transactional
    List<BookDto> getBooksDto(int page, int count);

    @Transactional
    List<Integer> getPageList(int currentPage);

    List<Integer> getPageList(int currentPage, int elementsInPage);

    @Transactional
    Book getBook(Long id);

    @Transactional
    BookDto getBookDto(Long id);

    @Transactional
    void save(BookForm bookForm);
}
