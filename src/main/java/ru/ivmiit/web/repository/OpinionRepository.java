package ru.ivmiit.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ivmiit.web.model.Opinion;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion, Long>{
}
