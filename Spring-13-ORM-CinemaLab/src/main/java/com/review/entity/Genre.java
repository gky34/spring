package com.review.entity;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import java.util.List;


@Entity
@NoArgsConstructor
@Getter @Setter
public class Genre extends BaseEntity
{

    private String name;

    @ManyToMany(mappedBy = "genreList")
    private List<Movie> movieList;

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                '}';
    }
}
