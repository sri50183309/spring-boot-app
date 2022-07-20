package com.sapient.xyz.bookingapp.movies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sapient.xyz.bookingapp.movies.Movie;
import com.sapient.xyz.bookingapp.theatre.Theatre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MOVIES_RUNNING_IN_THEATRE")
@NoArgsConstructor
@AllArgsConstructor
public class MovieRunningInTheatre {
    //TODO: Try auto number
    @Id
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    @JsonIgnoreProperties(value = {"movieRunningInTheatreList"}) //OMG -> A infinite loop fix *cant believe
    private Theatre theatre;


    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonIgnoreProperties(value = {"movieRunningInTheatreList"})
    private Movie movie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}

