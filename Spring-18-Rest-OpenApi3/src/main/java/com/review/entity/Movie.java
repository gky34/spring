package com.review.entity;

import com.review.entity.Genre;
import com.review.enums.MovieState;
import com.review.enums.MovieType;
import com.review.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Movie extends BaseEntity {

    private String name;

    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;

    private Integer duration;

    @Column(columnDefinition = "text")
    private String summary;

    @Enumerated(EnumType.STRING)
    private MovieType type;

    @Enumerated(EnumType.STRING)
    private MovieState state;

    private BigDecimal price;

    @ManyToMany
    @JoinTable(name = "movie_genre_rel", joinColumns = @JoinColumn(name = "movie_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genreList;

}