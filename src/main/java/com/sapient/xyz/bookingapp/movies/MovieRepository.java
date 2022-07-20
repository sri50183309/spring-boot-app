package com.sapient.xyz.bookingapp.movies;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long>{
    Movie findByName(String movieName);
}
