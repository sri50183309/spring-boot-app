package com.sapient.xyz.bookingapp.repository;

import com.sapient.xyz.bookingapp.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long>{
    Movie findByName(String movieName);
}
