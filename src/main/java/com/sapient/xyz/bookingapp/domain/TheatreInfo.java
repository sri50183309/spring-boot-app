package com.sapient.xyz.bookingapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheatreInfo {
    String name;
    String movieName;
    private String shows_times;
    private String start_date;
    private String end_date;
}
