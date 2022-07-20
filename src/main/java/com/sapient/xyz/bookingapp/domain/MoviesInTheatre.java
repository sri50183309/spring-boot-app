package com.sapient.xyz.bookingapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoviesInTheatre {
    @Size(min = 1, max = 255, message = "length 1-255")
    private List<TheatreInfo> theatres;
}
