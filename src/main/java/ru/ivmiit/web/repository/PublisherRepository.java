package ru.ivmiit.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ivmiit.web.model.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long>{
}
