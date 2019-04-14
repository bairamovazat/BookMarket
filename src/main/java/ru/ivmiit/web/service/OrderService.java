package ru.ivmiit.web.service;

import org.springframework.transaction.annotation.Transactional;
import ru.ivmiit.web.forms.OrderForm;
import ru.ivmiit.web.model.Order;
import ru.ivmiit.web.model.OrderStatus;
import ru.ivmiit.web.transfer.OrderDto;

import java.util.List;

public interface OrderService {
    @Transactional
    void save(OrderForm orderForm);

    @Transactional
    List<Integer> getCurrentUserPageList(int currentPage);

    List<Integer> getCurrentUserPageList(int currentPage, int elementsInPage);

    @Transactional
    List<OrderDto> getCurrentUserOrders(int page);

    @Transactional
    List<OrderDto> getCurrentUserOrders(int page, int count);

    @Transactional
    List<Integer> getAllPageList(int currentPage);

    List<Integer> getAllPageList(int currentPage, int elementsInPage);

    @Transactional
    List<OrderDto> getAllOrders(int page);

    @Transactional
    List<OrderDto> getAllOrders(int page, int count);

    @Transactional
    void changeStatus(Long orderId, OrderStatus orderStatus);
}
