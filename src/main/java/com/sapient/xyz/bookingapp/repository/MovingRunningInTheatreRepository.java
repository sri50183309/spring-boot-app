package com.sapient.xyz.bookingapp.repository;

import com.sapient.xyz.bookingapp.model.MovieRunningInTheatre;
import com.sapient.xyz.bookingapp.model.Theatre;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovingRunningInTheatreRepository extends CrudRepository<MovieRunningInTheatre, Long> , JpaSpecificationExecutor<Theatre> {
    List<MovieRunningInTheatre> findTheatreByMovieName(String movieName);
}
