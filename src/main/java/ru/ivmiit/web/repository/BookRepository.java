package ru.ivmiit.web.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.ivmiit.web.model.Book;
import ru.ivmiit.web.model.BookCategory;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>,
        PagingAndSortingRepository<Book, Long>{
    List<Book> findAllByIdIn(List<Long> ids);

    Page<Book> findAllByCategoryAndNameContains(BookCategory category, String nameContains, Pageable pageable);
    Page<Book> findAllByCategory(BookCategory category, Pageable pageable);
    Page<Book> findAllByNameContains(String nameContains, Pageable pageable);

    Long countAllByCategoryAndNameContains(BookCategory category, String nameContains);
    Long countAllByCategory(BookCategory category);
    Long countAllByNameContains( String nameContains);

}
