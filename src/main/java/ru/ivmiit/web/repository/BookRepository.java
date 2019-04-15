package ru.ivmiit.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.ivmiit.web.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>,
        PagingAndSortingRepository<Book, Long>{
    List<Book> findAllByIdIn(List<Long> ids);
}
