package ru.ivmiit.web.repository;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.ivmiit.web.model.Book;
import ru.ivmiit.web.model.Discount;

import java.util.Optional;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, Long>,
        PagingAndSortingRepository<Discount, Long> {

    Page<Discount> findAllByDeletedNot(Boolean bool, Pageable var1);
    Long countAllByDeletedNot(Boolean bool);

    Optional<Discount> findDiscountByCodeAndDeletedNot(String codem, Boolean deletedDot);
}
