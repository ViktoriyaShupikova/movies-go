package com.wsiz.moviego.mapper;

import com.wsiz.moviego.dto.MovieDto;
import com.wsiz.moviego.model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {

    public List<Movie> mapFromDto(List<MovieDto> movieDtos){
        List<Movie> movies = new ArrayList<>();

        movieDtos.forEach(movieDto -> {
            Movie movie = Movie.builder()
                    .name(movieDto.getName())
                    .description(movieDto.getDescription())
                    .posterUrl(movieDto.getPosterUrl())
                    .rating(movieDto.getRating())
                    .build();
            movies.add(movie);
        });

        return movies;
    }
}
