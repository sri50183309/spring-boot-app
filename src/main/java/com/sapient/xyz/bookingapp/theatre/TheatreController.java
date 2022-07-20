package com.sapient.xyz.bookingapp.theatre;

import com.sapient.xyz.bookingapp.domain.MoviesInTheatre;
import com.sapient.xyz.bookingapp.domain.TheatreInfo;
import com.sapient.xyz.bookingapp.model.Theatre;
import com.sapient.xyz.bookingapp.repository.MovieRepository;
import com.sapient.xyz.bookingapp.model.MovieRunningInTheatre;
import com.sapient.xyz.bookingapp.repository.MovingRunningInTheatreRepository;
import com.sapient.xyz.bookingapp.repository.TheatreRespository;
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
    TheatreService theatreService;

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
        Optional<Theatre> theatre = theatreService.findById(new Long(theatreId));
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
        theatreService.save(theatre);
        return new ResponseEntity<>(theatre, HttpStatus.OK);
    }

    @GetMapping(value = "/theatreShowingMovie/{movieName}", produces = "application/json")
    @ApiOperation(value = "Find a theatre by movie running", notes = "Find Theatres for a movie")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success", response = MoviesInTheatre.class),
                    @ApiResponse(code = 400, message = "Success", response = MoviesInTheatre.class),
                    @ApiResponse(code = 401, message = "Success", response = MoviesInTheatre.class),
                    @ApiResponse(code = 404, message = "Success", response = MoviesInTheatre.class),
                    @ApiResponse(code = 500, message = "Success", response = MoviesInTheatre.class),
                    @ApiResponse(code = 0, message = "Success", response = MoviesInTheatre.class)
            }
    )
    public ResponseEntity<MoviesInTheatre> findTheatreByRunningMovie (@PathVariable("movieName") @Valid @ApiParam(required = true, example = "RRR" )   String movieName) {
        MoviesInTheatre moviesInTheatre = theatreService.findTheatreByMovieName(movieName);
        return new ResponseEntity<>(moviesInTheatre, HttpStatus.OK);
    }

    @PostMapping(value = "/theatreShowingMovie", produces = "application/json")
    @ApiOperation(value = "Add movie show to a theatre", notes = "Add new movie show")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success", response = MovieRunningInTheatre.class),
                    @ApiResponse(code = 400, message = "Success", response = MovieRunningInTheatre.class),
                    @ApiResponse(code = 401, message = "Success", response = MovieRunningInTheatre.class),
                    @ApiResponse(code = 404, message = "Success", response = MovieRunningInTheatre.class),
                    @ApiResponse(code = 500, message = "Success", response = MovieRunningInTheatre.class),
                    @ApiResponse(code = 0, message = "Success", response = MovieRunningInTheatre.class)
            }
    )
    public ResponseEntity<MovieRunningInTheatre> createShowForTheatre(@RequestBody TheatreInfo theatre) {
        MovieRunningInTheatre movieRunningInTheatre1 = theatreService.saveTheatreMovieInfo(theatre);
        return new ResponseEntity<>(movieRunningInTheatre1, HttpStatus.OK);
    }
}
