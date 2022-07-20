package com.sapient.xyz.bookingapp.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MOVIES_RUNNING")
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    //TODO: Try auto number
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<MovieRunningInTheatre> movieRunningInTheatreList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MovieRunningInTheatre> getMovieRunningInTheatreList() {
        return movieRunningInTheatreList;
    }

    public void setMovieRunningInTheatreList(List<MovieRunningInTheatre> movieRunningInTheatreList) {
        this.movieRunningInTheatreList = movieRunningInTheatreList;
    }
}