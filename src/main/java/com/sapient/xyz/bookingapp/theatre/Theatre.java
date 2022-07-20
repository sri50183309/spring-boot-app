package com.sapient.xyz.bookingapp.theatre;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sapient.xyz.bookingapp.movies.MovieRunningInTheatre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "THEATRE")
@NoArgsConstructor
@AllArgsConstructor
public class Theatre {
    //TODO: Try auto number
    @Id
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @ToString.Exclude
    @OneToMany(mappedBy = "theatre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    private List<MovieRunningInTheatre> movieRunningInTheatreList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MovieRunningInTheatre> getMovieRunningInTheatreList() {
        return movieRunningInTheatreList;
    }

    public void setMovieRunningInTheatreList(List<MovieRunningInTheatre> movieRunningInTheatreList) {
        this.movieRunningInTheatreList = movieRunningInTheatreList;
    }
}
