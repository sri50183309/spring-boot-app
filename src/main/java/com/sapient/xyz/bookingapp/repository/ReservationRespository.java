package com.sapient.xyz.bookingapp.repository;

import com.sapient.xyz.bookingapp.model.Reservation;
import com.sapient.xyz.bookingapp.model.Theatre;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRespository extends CrudRepository<Reservation, Long> {
}