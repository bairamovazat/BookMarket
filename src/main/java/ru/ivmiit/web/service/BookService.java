package ru.ivmiit.web.service;

import org.springframework.transaction.annotation.Transactional;
import ru.ivmiit.web.forms.BookForm;
import ru.ivmiit.web.model.Book;
import ru.ivmiit.web.model.BookCategory;
import ru.ivmiit.web.transfer.BookDto;

import java.util.List;

public interface BookService {

    @Transactional
    List<Book> getBooks(int page, String nameContains, BookCategory bookCategory);

    @Transactional
    List<Book> getBooks(int page, int count, String nameContains, BookCategory bookCategory);

    @Transactional
    List<BookDto> getBooksDto(int page, String nameContains, BookCategory bookCategory);

    @Transactional
    List<BookDto> getBooksDto(int page, int count, String nameContains, BookCategory bookCategory);

    @Transactional
    List<Integer> getPageList(int currentPage, String nameContains, BookCategory bookCategory);

    List<Integer> getPageList(int currentPage, int elementsInPage, String nameContains, BookCategory bookCategory);

    @Transactional
    Book getBook(Long id);

    @Transactional
    BookDto getBookDto(Long id);

    @Transactional
    void save(BookForm bookForm);

    void delete(Long bookId);

    List<BookDto> getEditorChoseBooks();

    List<BookDto> getSaleBooks();

    List<BookDto> getDayBooks();

    List<BookDto> getFictionBooks();

    void sendComment(Long bookId, String text);
}
