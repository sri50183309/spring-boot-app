package com.sapient.xyz.bookingapp.repository;

import com.sapient.xyz.bookingapp.model.Theatre;
import org.springframework.data.repository.CrudRepository;

public interface TheatreRespository extends CrudRepository<Theatre, Long> {
    Theatre findByName(String name);
}