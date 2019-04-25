package ru.ivmiit.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ivmiit.web.forms.OrderBook;
import ru.ivmiit.web.forms.OrderForm;
import ru.ivmiit.web.model.*;
import ru.ivmiit.web.repository.BookRepository;
import ru.ivmiit.web.repository.DiscountRepository;
import ru.ivmiit.web.repository.OrderRepository;
import ru.ivmiit.web.transfer.OrderDto;
import ru.ivmiit.web.utils.TaskUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private DiscountRepository discountRepository;

    private static int paginationPagesCount = 5;

    private static int defaultElementsInPage = 15;

    @Transactional
    @Override
    public void save(OrderForm orderForm) {
        User user = authenticationService.getCurrentUser();
        List<Book> allBooks = bookRepository.findAllByIdIn(orderForm.getOrderBooksList()
                .stream()
                .map(OrderBook::getId)
                .collect(Collectors.toList()));

        Double price = allBooks.stream().mapToDouble(book ->
                orderForm.getBooks().stream().filter(e -> e.getId().equals(book.getId())).findFirst().get().getCount()
                        * book.getPrice()).sum();

        Optional<Discount> discount = discountRepository.findDiscountByCodeAndDeletedNot(orderForm.getSaleCode(), true);

        if (discount.isPresent()) {
            price = price / 100 * (100 - discount.get().getSalePercent());
        }

        Order order = Order.builder()
                .user(user)
                .address(orderForm.getAddress())
                .status(OrderStatus.CREATE)
                .payAfterDelivery(orderForm.getPayAfterDelivery())
                .createDate(new Date())
                .comment(orderForm.getComment())
                .price(price)
                .discount(discount.orElse(null))
                .build();

        List<OrdersBooks> ordersBooks = allBooks.stream()
                .map(book -> OrdersBooks.builder()
                        .count(
                                orderForm.getOrderBooksList().stream()
                                        .filter(e -> e.getId().equals(book.getId()))
                                        .findFirst()
                                        .orElseThrow(() -> new IllegalArgumentException("book not found"))
                                        .getCount()
                        )
                        .book(book)
                        .order(order)
                        .build())
                .collect(Collectors.toList());

        order.setBooks(ordersBooks);

        orderRepository.save(order);
    }


    @Override
    @Transactional
    public List<Integer> getCurrentUserPageList(int currentPage) {
        return getCurrentUserPageList(currentPage, defaultElementsInPage);
    }

    @Override
    public List<Integer> getCurrentUserPageList(int currentPage, int elementsInPage) {
        User user = authenticationService.getCurrentUser();
        int pageCount = (int) Math.ceil(((double) orderRepository.countAllByUser(user)) / elementsInPage);
        int maxPage = pageCount - 1;
        return TaskUtils.getPageList(currentPage, paginationPagesCount, maxPage);
    }

    @Override
    @Transactional
    public List<OrderDto> getCurrentUserOrders(int page) {
        return getCurrentUserOrders(page, defaultElementsInPage);
    }

    @Override
    @Transactional
    public List<OrderDto> getCurrentUserOrders(int page, int count) {
        User user = authenticationService.getCurrentUser();

        return orderRepository.findAllByUser(user, PageRequest.of(page, count, new Sort(Sort.Direction.DESC, "createDate")))
                .getContent()
                .stream()
                .map(OrderDto::from)
                .collect(Collectors.toList());
    }


    @Override
    @Transactional
    public List<Integer> getAllPageList(int currentPage) {
        return getCurrentUserPageList(currentPage, defaultElementsInPage);
    }

    @Override
    public List<Integer> getAllPageList(int currentPage, int elementsInPage) {
        User user = authenticationService.getCurrentUser();
        int pageCount = (int) Math.ceil(((double) orderRepository.count()) / elementsInPage);
        int maxPage = pageCount - 1;
        return TaskUtils.getPageList(currentPage, paginationPagesCount, maxPage);
    }

    @Override
    @Transactional
    public List<OrderDto> getAllOrders(int page) {
        return getAllOrders(page, defaultElementsInPage);
    }

    @Override
    @Transactional
    public List<OrderDto> getAllOrders(int page, int count) {
        return orderRepository.findAll(PageRequest.of(page, count, new Sort(Sort.Direction.DESC, "createDate")))
                .getContent()
                .stream()
                .map(OrderDto::from)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void changeStatus(Long orderId, OrderStatus orderStatus) {
        Order order = orderRepository.getOne(orderId);
        order.setStatus(orderStatus);
        orderRepository.save(order);
    }
}
