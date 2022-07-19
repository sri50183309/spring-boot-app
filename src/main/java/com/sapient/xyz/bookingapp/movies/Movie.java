package com.sapient.xyz.bookingapp.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    //TODO: Try auto number
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;
}