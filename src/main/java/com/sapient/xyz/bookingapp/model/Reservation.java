package com.sapient.xyz.bookingapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "RESERVATION")
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    //TODO: Try auto number
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "movies_theatre_id")
    private MovieRunningInTheatre moviesRunningInTheatre;

   @Column(nullable = false)
    private String customer_name;

    @Column(nullable = false)
    private String seat_pref;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovieRunningInTheatre getMoviesRunningInTheatre() {
        return moviesRunningInTheatre;
    }

    public void setMoviesRunningInTheatre(MovieRunningInTheatre moviesRunningInTheatre) {
        this.moviesRunningInTheatre = moviesRunningInTheatre;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getSeat_pref() {
        return seat_pref;
    }

    public void setSeat_pref(String seat_pref) {
        this.seat_pref = seat_pref;
    }
}

