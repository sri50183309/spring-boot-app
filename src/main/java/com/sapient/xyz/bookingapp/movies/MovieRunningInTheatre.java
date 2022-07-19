package com.sapient.xyz.bookingapp.movies;

import com.sapient.xyz.bookingapp.movies.Movie;
import com.sapient.xyz.bookingapp.theatre.Theatre;

import javax.persistence.Column;
import javax.persistence.Id;

public class MovieRunningInTheatre {
    //TODO: Try auto number
    @Id
    private Long id;

    @Column(nullable = false)
    private Theatre name;

    @Column(nullable = false)
    private Movie movie;
}

