package com.wsiz.moviego.repository;

import com.wsiz.moviego.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Interfejs Jpa dla zapisu objektów bazy danych
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {

    /**
     * Wyszukiwania filmu z bazy danych po nazwie
     * @param name
     * @return
     */
    List<Movie> findByNameIgnoreCaseContaining(String name);
}
