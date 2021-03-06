package com.wsiz.moviego.controller;

import com.wsiz.moviego.model.Movie;
import com.wsiz.moviego.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Kontroller który wystawia API do web serwisu
 */
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * Wyszukiwania filmu
     * @param query paramerty wyszukiwania
     * @return zwraca listę wyszukiwanych filmów
     */
    @GetMapping("/search")
    public List<Movie> searchMovies(@RequestParam("query") String query){
        return movieService.searchMovies(query);
    }

    /**
     * Pobrania pojedynczego filmu
     * @param id id pojedynczego filmu
     * @return zwraca szczegóły filmu
     */
    @GetMapping("/search/{id}")
    public Optional<Movie> searchMovies(@PathVariable("id") Long id){
        return movieService.getById(id);
    }

    /**
     * Pobrania popularnych filmów
     * @return zwraca listę popularnych filmów
     */
    @GetMapping("/popular")
    public List<Movie> getPopular(){
        return movieService.getPopular();
    }
}
