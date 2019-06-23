package com.wsiz.moviego.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Model object'u bazy danych pojedynczego filmu
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private Long id;

    @Column
    private String name;

    @Column
    private String posterUrl;

    @Column(length = 1000)
    private String description;

    @Column
    private BigDecimal rating;


}
