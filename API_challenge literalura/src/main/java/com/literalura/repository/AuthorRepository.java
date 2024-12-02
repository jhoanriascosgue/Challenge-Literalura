package com.literalura.repository;

import com.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT DISTINCT a FROM Author a WHERE :year BETWEEN a.birthYear AND a.deathYear")
    List<Author> findAuthorsAliveInYear(Integer year);
}