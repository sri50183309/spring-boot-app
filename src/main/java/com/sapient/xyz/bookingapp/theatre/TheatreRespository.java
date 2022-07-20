package com.sapient.xyz.bookingapp.theatre;

import org.springframework.data.repository.CrudRepository;

public interface TheatreRespository extends CrudRepository<Theatre, Long> {
    Theatre findByName(String name);
}