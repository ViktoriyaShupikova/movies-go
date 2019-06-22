package com.wsiz.moviego.client;

import com.wsiz.moviego.dto.ApiListResponse;
import com.wsiz.moviego.dto.MovieDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "themoviedbclient", url="https://api.themoviedb.org/3/")
public interface TheMovieDbClient {

    @RequestMapping(method = RequestMethod.GET, value = "search/movie")
    ApiListResponse<MovieDto> searchMovies(@RequestParam("api_key") String apiKey, @RequestParam("query") String query);

    @RequestMapping(method = RequestMethod.GET, value = "movie/popular")
    ApiListResponse<MovieDto> getPopular(@RequestParam("api_key") String apiKey);
}
