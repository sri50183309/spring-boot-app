package com.sapient.xyz.bookingapp.repository;

import com.sapient.xyz.bookingapp.model.MovieRunningInTheatre;
import com.sapient.xyz.bookingapp.model.Theatre;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovingRunningInTheatreRepository extends CrudRepository<MovieRunningInTheatre, Long> , JpaSpecificationExecutor<Theatre> {
    List<MovieRunningInTheatre> findTheatreByMovieName(String movieName);
    @Query("select id from MovieRunningInTheatre " +
            "where theatre.name=:theatre " +
            "and movie.name = :movie " +
            " and showTimes = :showTimes")
    Long findMovingRunningInTheatreByTheatreNameAndMovieName(String theatre, String movie, String showTimes);
}
