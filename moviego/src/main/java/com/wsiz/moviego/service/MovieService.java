package com.wsiz.moviego.service;

import com.wsiz.moviego.client.TheMovieDbClient;
import com.wsiz.moviego.mapper.MovieMapper;
import com.wsiz.moviego.model.Movie;
import com.wsiz.moviego.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Service do wyszukiwania filmów
 */
@Component
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private TheMovieDbClient client;

    @Value("${themoviedb.apiKey}")
    private String apiKey;

    /**
     * Wyszukiwania filmu
     * @param query paramert wyszukiwania
     * @return
     */
    public List<Movie> searchMovies(String query){

        List<Movie> movies = movieRepository.findByNameIgnoreCaseContaining(query);

        if(movies.size() == 0){
            movies = movieMapper.mapFromDto(client.searchMovies(apiKey, query).getResults());

            movieRepository.saveAll(movies);
        }

        return movies;
    }

    /**
     * Pobrania popopularnych filmów
     * @return
     */
    public List<Movie> getPopular(){
        List<Movie> popularMovies = movieMapper.mapFromDto(client.getPopular(apiKey).getResults());
        movieRepository.saveAll(popularMovies);
        return popularMovies;
    }

    /**
     * Pobrania pojedynczego filmu z podaniem parametru id
     * @param id
     * @return
     */
    public Optional<Movie> getById(Long id){
        return movieRepository.findById(id);
    }
}
