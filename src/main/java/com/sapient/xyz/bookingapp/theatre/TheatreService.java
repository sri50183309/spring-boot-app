package com.sapient.xyz.bookingapp.theatre;

import com.sapient.xyz.bookingapp.domain.MoviesInTheatre;
import com.sapient.xyz.bookingapp.domain.TheatreInfo;
import com.sapient.xyz.bookingapp.model.MovieRunningInTheatre;
import com.sapient.xyz.bookingapp.model.Theatre;
import com.sapient.xyz.bookingapp.repository.MovieRepository;
import com.sapient.xyz.bookingapp.repository.MovingRunningInTheatreRepository;
import com.sapient.xyz.bookingapp.repository.TheatreRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TheatreService {
    @Autowired
    TheatreRespository theatreRespository;

    @Autowired
    MovingRunningInTheatreRepository movingRunningInTheatreRepository;

    @Autowired
    MovieRepository movieRepository;


    public Optional<Theatre> findById(Long theatreId) {
        return theatreRespository.findById(new Long(theatreId));
    }

    public void save(Theatre theatre) {
        theatreRespository.save(theatre);
    }

    public MoviesInTheatre findTheatreByMovieName(String movieName) {
        List<MovieRunningInTheatre> movieRunningInTheatre = movingRunningInTheatreRepository.findTheatreByMovieName(movieName);
        List<TheatreInfo> theatreList = new ArrayList<>();
        theatreList = movieRunningInTheatre.stream()
                .map(it -> new TheatreInfo(
                        it.getTheatre().getName(),
                        it.getShowTimes(),
                        it.getStart_date(),
                        it.getEnd_date(),
                        it.getMovie().getName()))
                .distinct()
                .collect(Collectors.toList());
        MoviesInTheatre moviesInTheatre = new MoviesInTheatre();
        moviesInTheatre.setTheatres(theatreList);
        return moviesInTheatre;
    }

    public MovieRunningInTheatre saveTheatreMovieInfo(TheatreInfo theatre) {
        //theatreRespository.save(theatre);
        MovieRunningInTheatre movieRunningInTheatre = new MovieRunningInTheatre();
        movieRunningInTheatre.setTheatre(theatreRespository.findByName(theatre.getName()));
        movieRunningInTheatre.setMovie(movieRepository.findByName(theatre.getMovieName()));
        movieRunningInTheatre.setEnd_date(theatre.getEnd_date());
        movieRunningInTheatre.setStart_date(theatre.getStart_date());
        movieRunningInTheatre.setShowTimes(theatre.getShows_times());
        return movingRunningInTheatreRepository.save(movieRunningInTheatre);
    }
}
