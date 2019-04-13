package ru.ivmiit.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ivmiit.web.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
}
