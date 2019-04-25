package ru.ivmiit.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import java.util.Optional;
import java.util.Random;
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
    private static Random random = new Random();

    @Override
    @Transactional
    public List<Book> getBooks(int page, String nameContains, BookCategory bookCategory) {
        return getBooks(page, defaultElementsInPage, nameContains, bookCategory);
    }


    @Override
    @Transactional
    public List<Book> getBooks(int page, int count, String nameContains, BookCategory bookCategory) {
        Pageable pageable = PageRequest.of(page, count, new Sort(Sort.Direction.ASC, "id"));
        if(nameContains != null && bookCategory != null){
            return bookRepository.findAllByCategoryAndNameContains(bookCategory, nameContains, pageable).getContent();
        }else if(nameContains != null){
            return bookRepository.findAllByNameContains(nameContains, pageable).getContent();
        } else if(bookCategory != null){
            return bookRepository.findAllByCategory(bookCategory, pageable).getContent();
        }else {
            return bookRepository.findAll(PageRequest.of(page, count, new Sort(Sort.Direction.ASC, "id"))).getContent();
        }
    }

    @Override
    @Transactional
    public List<BookDto> getBooksDto(int page, String nameContains, BookCategory bookCategory) {
        return getBooks(page, nameContains, bookCategory).stream().map(BookDto::from).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<BookDto> getBooksDto(int page, int count, String nameContains, BookCategory bookCategory) {
        return getBooks(page, count, nameContains, bookCategory).stream().map(BookDto::from).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<Integer> getPageList(int currentPage, String nameContains, BookCategory bookCategory) {
        return getPageList(currentPage, defaultElementsInPage, nameContains, bookCategory);
    }

    @Override
    public List<Integer> getPageList(int currentPage, int elementsInPage, String nameContains, BookCategory bookCategory) {
        Long booksCount;

        if(nameContains != null && bookCategory != null){
            booksCount = bookRepository.countAllByCategoryAndNameContains(bookCategory, nameContains);
        }else if(nameContains != null){
            booksCount = bookRepository.countAllByNameContains(nameContains);
        } else if(bookCategory != null){
            booksCount = bookRepository.countAllByCategory(bookCategory);
        }else {
            booksCount = bookRepository.count();
        }

        int pageCount = (int) Math.ceil(((double) booksCount) / elementsInPage);
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

    @Override
    public void delete(Long bookId){
        bookRepository.deleteById(bookId);
    }

    @Override
    @Transactional
    public List<BookDto> getEditorChoseBooks(){
        return getRandomBooks(4).stream().map(BookDto::from).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<BookDto> getSaleBooks(){
        return getRandomBooks(4).stream().map(BookDto::from).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<BookDto> getDayBooks(){
        return getRandomBooks(4).stream().map(BookDto::from).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<BookDto> getFictionBooks(){
        return getRandomBooks(4).stream().map(BookDto::from).collect(Collectors.toList());
    }

    public List<Book> getRandomBooks(int count){
        long bookCount = bookRepository.count();
        long pageCount = bookCount / count;
        int currentPage = random.nextInt((int)pageCount);
        return bookRepository.findAll(PageRequest.of(currentPage, count)).getContent();
    }

}
