package com.sapient.xyz.bookingapp.theatre;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value = "/xyz/theatre")
public class TheatreController {

    @Autowired
    TheatreRespository theatreRespository;

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
}
