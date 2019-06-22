package com.wsiz.moviego.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class MovieDto {

    @JsonProperty("vote_average")
    private BigDecimal rating;

    @JsonProperty("title")
    private String name;

    @JsonProperty("poster_path")
    private String posterUrl;

    @JsonProperty("overview")
    private String description;
}
