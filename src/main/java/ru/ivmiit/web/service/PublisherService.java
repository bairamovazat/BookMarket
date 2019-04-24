package ru.ivmiit.web.service;

import org.springframework.transaction.annotation.Transactional;
import ru.ivmiit.web.forms.PublisherForm;
import ru.ivmiit.web.model.Book;
import ru.ivmiit.web.model.Publisher;

import java.util.List;

public interface PublisherService {

    @Transactional
    List<Publisher> getPublishers(int page);

    @Transactional
    List<Publisher> getPublishers(int page, int count);

    @Transactional
    List<Integer> getPageList(int currentPage);

    List<Integer> getPageList(int currentPage, int elementsInPage);

    @Transactional
    Publisher getPublisher(Long id);

    @Transactional
    void save(PublisherForm publisherForm);

    void delete(Long bookId);

    @Transactional
    List<Publisher> getAllCategories();
}
