package ru.ivmiit.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivmiit.web.forms.BookForm;
import ru.ivmiit.web.model.Book;
import ru.ivmiit.web.model.BookCategory;
import ru.ivmiit.web.model.File;
import ru.ivmiit.web.model.Publisher;
import ru.ivmiit.web.repository.BookCategoryRepository;
import ru.ivmiit.web.repository.BookRepository;
import ru.ivmiit.web.repository.PublisherRepository;
import ru.ivmiit.web.transfer.BookDto;
import ru.ivmiit.web.utils.TaskUtils;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class BookServiceImpl implements BookService {

    static Logger logger = LoggerFactory.getLogger(BookService.class.getName());

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private FileService fileService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Autowired
    private PublisherRepository publisherRepository;

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
    public List<BookDto> getBooksDto(int page) {
        return getBooks(page).stream().map(BookDto::from).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<BookDto> getBooksDto(int page, int count) {
        return getBooks(page, count).stream().map(BookDto::from).collect(Collectors.toList());
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
    public Book getBook(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book not fount"));
    }

    @Override
    @Transactional
    public BookDto getBookDto(Long id) {
        return BookDto.from(getBook(id));
    }

    @Override
    @Transactional
    public void save(BookForm bookForm){
        BookCategory category = bookCategoryRepository.getOne(bookForm.getCategoryId());
        Publisher publisher= publisherRepository.getOne(bookForm.getPublisherId());
        File file;
        try {
            file = fileService.saveFile(bookForm.getTitlePage());
        } catch (IOException e) {
            throw new IllegalArgumentException("Save file error");
        }

        Book book = Book.from(bookForm);
        book.setCategory(category);
        book.setPublisher(publisher);
        book.setTitlePage(file);

        bookRepository.save(book);
    }


}
