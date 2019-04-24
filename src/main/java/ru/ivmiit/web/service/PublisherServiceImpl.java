package ru.ivmiit.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivmiit.web.forms.PublisherForm;
import ru.ivmiit.web.model.Book;
import ru.ivmiit.web.model.Publisher;
import ru.ivmiit.web.repository.BookCategoryRepository;
import ru.ivmiit.web.repository.BookRepository;
import ru.ivmiit.web.repository.PublisherRepository;
import ru.ivmiit.web.utils.TaskUtils;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    static Logger logger = LoggerFactory.getLogger(BookService.class.getName());

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private PublisherRepository publisherRepository;

    private static int paginationPagesCount = 5;

    private static int defaultElementsInPage = 15;

    @Override
    @Transactional
    public List<Publisher> getPublishers(int page) {
        return getPublishers(page, defaultElementsInPage);
    }

    @Override
    @Transactional
    public List<Publisher> getPublishers(int page, int count) {
        return publisherRepository.findAll(PageRequest.of(page, count)).getContent();
    }

    @Override
    @Transactional
    public List<Integer> getPageList(int currentPage) {
        return getPageList(currentPage, defaultElementsInPage);
    }

    @Override
    public List<Integer> getPageList(int currentPage, int elementsInPage) {
        int pageCount = (int) Math.ceil(((double) publisherRepository.count()) / elementsInPage);
        int maxPage = pageCount - 1;
        return TaskUtils.getPageList(currentPage, paginationPagesCount, maxPage);
    }

    @Override
    @Transactional
    public Publisher getPublisher(Long id) {
        return publisherRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Publisher not fount"));
    }

    @Override
    @Transactional
    public void save(PublisherForm publisherForm){
        Publisher publisher;
        if(publisherForm.getId() != null){
            publisher = publisherRepository.findById(publisherForm.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Publisher category not found"));

        }else {
            publisher = new Publisher();
        }

        publisher.setName(publisherForm.getName());
        publisherRepository.save(publisher);
    }

    @Override
    public void delete(Long bookId){
        publisherRepository.deleteById(bookId);
    }

    @Override
    @Transactional
    public List<Publisher> getAllCategories() {
        return publisherRepository.findAll();
    }

}
