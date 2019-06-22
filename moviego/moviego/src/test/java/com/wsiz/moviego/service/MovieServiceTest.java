package com.wsiz.moviego.service;

import com.wsiz.moviego.client.TheMovieDbClient;
import com.wsiz.moviego.dto.ApiListResponse;
import com.wsiz.moviego.dto.MovieDto;
import com.wsiz.moviego.mapper.MovieMapper;
import com.wsiz.moviego.model.Movie;
import com.wsiz.moviego.repository.MovieRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class MovieServiceTest {

    @Mock
    private TheMovieDbClient client;

    @Mock
    private MovieRepository movieRepository;

    @Spy
    private MovieMapper movieMapper = new MovieMapper();

    @InjectMocks
    private MovieService movieService;

    @Test
    public void searchMoviesFromApi() {
        String query = "asd";

        ApiListResponse<MovieDto> apiListResponse = new ApiListResponse<>();
        MovieDto movieDto = new MovieDto();
        movieDto.setDescription("desc");
        movieDto.setPosterUrl("poster");
        movieDto.setName("name");
        movieDto.setRating(BigDecimal.TEN);

        apiListResponse.setResults(Arrays.asList(movieDto));
        Mockito.when(movieRepository.findByNameIgnoreCaseContaining("asd")).thenReturn(new ArrayList<>());
        Mockito.when(client.searchMovies(null, "asd")).thenReturn(apiListResponse);

        List<Movie> movieList = movieService.searchMovies(query);

        Assert.assertEquals("desc", movieList.get(0).getDescription());
        Assert.assertEquals("poster", movieList.get(0).getPosterUrl());
        Assert.assertEquals("name", movieList.get(0).getName());
        Assert.assertEquals(BigDecimal.TEN, movieList.get(0).getRating());
    }
    @Test
    public void searchMoviesFromDatabase() {
        String query = "asd";

        ApiListResponse<MovieDto> apiListResponse = new ApiListResponse<>();
        MovieDto movieDto = new MovieDto();
        movieDto.setDescription("desc");
        movieDto.setPosterUrl("poster");
        movieDto.setName("name");
        movieDto.setRating(BigDecimal.TEN);

        Movie movie = Movie.builder()
                .rating(BigDecimal.ONE)
                .name("qwe")
                .description("descr")
                .posterUrl("posterBase")
                .build();

        apiListResponse.setResults(Arrays.asList(movieDto));
        Mockito.when(movieRepository.findByNameIgnoreCaseContaining("asd")).thenReturn(Arrays.asList(movie));
        Mockito.when(client.searchMovies(null, "asd")).thenReturn(apiListResponse);

        List<Movie> movieList = movieService.searchMovies(query);

        Assert.assertEquals("descr", movieList.get(0).getDescription());
        Assert.assertEquals("posterBase", movieList.get(0).getPosterUrl());
        Assert.assertEquals("qwe", movieList.get(0).getName());
        Assert.assertEquals(BigDecimal.ONE, movieList.get(0).getRating());
    }
}