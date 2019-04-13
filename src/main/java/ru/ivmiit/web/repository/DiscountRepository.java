package ru.ivmiit.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ivmiit.web.model.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long>{
}
