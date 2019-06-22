package com.wsiz.moviego.controller;

import com.wsiz.moviego.model.Movie;
import com.wsiz.moviego.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/search")
    public List<Movie> searchMovies(@RequestParam("query") String query){
        return movieService.searchMovies(query);
    }

    @GetMapping("/search/{id}")
    public Optional<Movie> searchMovies(@PathVariable("id") Long id){
        return movieService.getById(id);
    }

    @GetMapping("/popular")
    public List<Movie> getPopular(){
        return movieService.getPopular();
    }
}
