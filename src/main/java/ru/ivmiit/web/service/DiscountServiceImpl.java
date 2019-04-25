package ru.ivmiit.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.ivmiit.web.forms.DiscountForm;
import ru.ivmiit.web.model.Discount;
import ru.ivmiit.web.repository.DiscountRepository;
import ru.ivmiit.web.utils.TaskUtils;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    static Logger logger = LoggerFactory.getLogger(DiscountService.class.getName());

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private DiscountRepository discountRepository;

    private static int paginationPagesCount = 5;

    private static int defaultElementsInPage = 15;

    @Override
    @Transactional
    public List<Discount> getDiscounts(int page) {
        return getDiscounts(page, defaultElementsInPage);
    }

    @Override
    @Transactional
    public List<Discount> getDiscounts(int page, int count) {
        return discountRepository.findAllByDeletedNot(true, PageRequest.of(page, count)).getContent();
    }

    @Override
    @Transactional
    public List<Integer> getPageList(int currentPage) {
        return getPageList(currentPage, defaultElementsInPage);
    }

    @Override
    public List<Integer> getPageList(int currentPage, int elementsInPage) {
        int pageCount = (int) Math.ceil(((double) discountRepository.countAllByDeletedNot(true)) / elementsInPage);
        int maxPage = pageCount - 1;
        return TaskUtils.getPageList(currentPage, paginationPagesCount, maxPage);
    }

    @Override
    @Transactional
    public Discount getDiscount(Long id) {
        return discountRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Discount not fount"));
    }

    @Override
    @Transactional
    public void save(DiscountForm discountForm){
        Discount discount;
        if(discountForm.getId() != null){
            discount = discountRepository.findById(discountForm.getId())
                    .orElseThrow(() -> new IllegalArgumentException("Discount not found"));

        }else {
            discount = new Discount();
        }
        discount.setDeleted(false);
        discount.setCode(discountForm.getCode());
        discount.setSalePercent(discountForm.getSalePercent());
        discountRepository.save(discount);
    }

    @Override
    public void delete(Long bookId){
        Discount discount = discountRepository.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("Discount not found"));
        discount.setDeleted(true);
        discountRepository.save(discount);
    }

    @Override
    @Transactional
    public List<Discount> getAllDiscount() {
        return discountRepository.findAll();
    }
}
