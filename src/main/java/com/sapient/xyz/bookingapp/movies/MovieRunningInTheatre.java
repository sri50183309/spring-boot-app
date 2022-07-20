package com.sapient.xyz.bookingapp.movies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sapient.xyz.bookingapp.movies.Movie;
import com.sapient.xyz.bookingapp.theatre.Theatre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "MOVIES_RUNNING_IN_THEATRE")
@NoArgsConstructor
@AllArgsConstructor
public class MovieRunningInTheatre {
    //TODO: Try auto number
    @Id
    @GeneratedValue(strategy = IDENTITY)
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

   @Column(nullable = false)
    private String shows_times;

    @Column(nullable = false)
    private String start_date;

    @Column(nullable = false)
    private String end_date;

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

    public String getShows_times() {
        return shows_times;
    }

    public void setShows_times(String shows_times) {
        this.shows_times = shows_times;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}

