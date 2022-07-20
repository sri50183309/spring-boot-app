package com.sapient.xyz.bookingapp.theatre;

import com.sapient.xyz.bookingapp.domain.MoviesInTheatre;
import com.sapient.xyz.bookingapp.domain.TheatreInfo;
import com.sapient.xyz.bookingapp.movies.Movie;
import com.sapient.xyz.bookingapp.movies.MovieRepository;
import com.sapient.xyz.bookingapp.movies.MovieRunningInTheatre;
import com.sapient.xyz.bookingapp.movies.MovingRunningInTheatreRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/xyz/theatre")
public class TheatreController {

    @Autowired
    TheatreRespository theatreRespository;

    @Autowired
    MovingRunningInTheatreRepository movingRunningInTheatreRepository;

    @Autowired
    MovieRepository movieRepository;

    @GetMapping(value = "/{theatreid}", produces = "application/json")
    @ApiOperation(value = "Find a theatre by id", notes = "Find Theatres")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 400, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 401, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 404, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 500, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 0, message = "Success", response = Theatre.class)
            }
    )
    public ResponseEntity<Theatre> list (@PathVariable("theatreid") @Valid @ApiParam(required = true, example = "1" , allowableValues = "range[0,999999]")   int theatreId) {
        Optional<Theatre> theatre = theatreRespository.findById(new Long(theatreId));
        if(theatre.isPresent())
            return new ResponseEntity<>(theatre.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    }

    @PostMapping(value = "/", produces = "application/json")
    @ApiOperation(value = "Creates a theatre", notes = "Add new theatre")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 400, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 401, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 404, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 500, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 0, message = "Success", response = Theatre.class)
            }
    )
    public ResponseEntity<Theatre> create (@RequestBody  Theatre theatre) {
        theatreRespository.save(theatre);
        return new ResponseEntity<>(theatre, HttpStatus.OK);
    }

    @GetMapping(value = "/theatreShowingMovie/{movieName}", produces = "application/json")
    @ApiOperation(value = "Find a theatre by movie running", notes = "Find Theatres for a movie")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 400, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 401, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 404, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 500, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 0, message = "Success", response = Theatre.class)
            }
    )
    public ResponseEntity<MoviesInTheatre> findTheatreByRunningMovie (@PathVariable("movieName") @Valid @ApiParam(required = true, example = "RRR" )   String movieName) {

        List<MovieRunningInTheatre> movieRunningInTheatre = movingRunningInTheatreRepository.findTheatreByMovieName(movieName);
        if(movieRunningInTheatre != null && movieRunningInTheatre.size() > 0){
            List<TheatreInfo> theatreList = new ArrayList<>();
            theatreList = movieRunningInTheatre.stream()
                    .map(it -> new TheatreInfo(
                            it.getTheatre().getName(),
                            it.getShows_times(),
                            it.getStart_date(),
                            it.getEnd_date(),
                            it.getMovie().getName()))
                    .distinct()
                    .collect(Collectors.toList());
            MoviesInTheatre moviesInTheatre = new MoviesInTheatre();
            moviesInTheatre.setTheatres(theatreList);
            return new ResponseEntity<>(moviesInTheatre, HttpStatus.OK);
        }else
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    }

    @PostMapping(value = "/theatreShowingMovie", produces = "application/json")
    @ApiOperation(value = "Creates a theatre", notes = "Add new theatre")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 400, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 401, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 404, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 500, message = "Success", response = Theatre.class),
                    @ApiResponse(code = 0, message = "Success", response = Theatre.class)
            }
    )
    public ResponseEntity<MovieRunningInTheatre> createShowForTheatre(@RequestBody TheatreInfo theatre) {
        //theatreRespository.save(theatre);
        MovieRunningInTheatre movieRunningInTheatre = new MovieRunningInTheatre();
        movieRunningInTheatre.setTheatre(theatreRespository.findByName(theatre.getName()));
        movieRunningInTheatre.setMovie(movieRepository.findByName(theatre.getMovieName()));
        movieRunningInTheatre.setEnd_date(theatre.getEnd_date());
        movieRunningInTheatre.setStart_date(theatre.getStart_date());
        movieRunningInTheatre.setShows_times(theatre.getShows_times());
        MovieRunningInTheatre movieRunningInTheatre1 = movingRunningInTheatreRepository.save(movieRunningInTheatre);
        return new ResponseEntity<>(movieRunningInTheatre1, HttpStatus.OK);
    }
}
