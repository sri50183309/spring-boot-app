package com.sapient.xyz.bookingapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoviesInTheatre {
    private List<TheatreInfo> theatres;
}
