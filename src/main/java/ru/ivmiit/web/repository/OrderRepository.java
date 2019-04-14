package ru.ivmiit.web.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.ivmiit.web.model.Order;
import ru.ivmiit.web.model.User;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, PagingAndSortingRepository<Order, Long> {
    Page<Order> findAllByUser(User user, Pageable pageable);

    Integer countAllByUser(User user);
}
