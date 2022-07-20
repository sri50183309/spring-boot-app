package com.sapient.xyz.bookingapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationInfo {
    @Size(min = 1, max = 255, message = "length 1-255")
    @Pattern(regexp = "([.])*", message = "Invalid name format")
    String theatreName;

    @Size(min = 1, max = 255, message = "length 1-255")
    @Pattern(regexp = "([.])*", message = "Invalid movieName format")
    String movieName;

    @Size(min = 1, max = 255, message = "length 1-255")
    @Pattern(regexp = "([.])*", message = "Invalid shows_times format")
    private String shows_times;

    @Size(min = 1, max = 255, message = "length 1-255")
    @Pattern(regexp = "([.])*", message = "Invalid name customerName")
    String customerName;

    @Size(min = 1, max = 255, message = "length 1-255")
    @Pattern(regexp = "([.])*", message = "Invalid name seatPref")
    String seatPref;

}
