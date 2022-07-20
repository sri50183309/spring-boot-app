package com.sapient.xyz.bookingapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheatreInfo {
    @Size(min = 1, max = 255, message = "length 1-255")
    @Pattern(regexp = "([.])*", message = "Invalid name format")
    String name;

    @Size(min = 1, max = 255, message = "length 1-255")
    @Pattern(regexp = "([.])*", message = "Invalid movieName format")
    String movieName;

    @Size(min = 1, max = 255, message = "length 1-255")
    @Pattern(regexp = "([.])*", message = "Invalid shows_times format")
    private String shows_times;

    @Size(min = 1, max = 255, message = "length 1-255")
    @Pattern(regexp = "([.])*", message = "Invalid start_date format")
    private String start_date;

    @Size(min = 1, max = 255, message = "length 1-255")
    @Pattern(regexp = "([.])*", message = "Invalid end_date format")
    private String end_date;
}
