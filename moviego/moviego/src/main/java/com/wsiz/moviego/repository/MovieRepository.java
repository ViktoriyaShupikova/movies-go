package com.wsiz.moviego.repository;

import com.wsiz.moviego.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByNameIgnoreCaseContaining(String name);
}
