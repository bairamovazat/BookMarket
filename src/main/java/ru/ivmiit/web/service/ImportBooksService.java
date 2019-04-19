package ru.ivmiit.web.service;

import org.springframework.transaction.annotation.Transactional;
import ru.ivmiit.web.model.Book;
import ru.ivmiit.web.transfer.BookDto;

import java.io.IOException;
import java.util.List;

public interface ImportBooksService {
    @Transactional
    List<Book> getBooksFrom(String path) throws IOException;

    @Transactional
    void saveAllBooks(List<Book> books);

    @Transactional
    List<BookDto> importAllBooks(String path) throws IOException;
}
