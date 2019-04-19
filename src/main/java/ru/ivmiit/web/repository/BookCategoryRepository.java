package ru.ivmiit.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.ivmiit.web.model.BookCategory;

import java.util.Optional;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long>,
        PagingAndSortingRepository<BookCategory, Long>{

    Optional<BookCategory> findByNameContainingIgnoreCase(String name);
}
