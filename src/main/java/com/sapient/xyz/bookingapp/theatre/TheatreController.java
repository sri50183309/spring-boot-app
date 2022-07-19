package com.sapient.xyz.bookingapp.theatre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/xyz/theatre")
public class TheatreController {

    @Autowired
    TheatreRespository theatreRespository;

    @GetMapping(value = "/{theatreid}", produces = "application/json")
    public ResponseEntity<Theatre> list (@PathVariable("theatreid")  int theatreId) {
        Optional<Theatre> theatre = theatreRespository.findById(new Long(theatreId));
        if(theatre.isPresent())
            return new ResponseEntity<>(theatre.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Theatre> create (@RequestBody  Theatre theatre) {
        theatreRespository.save(theatre);
        return new ResponseEntity<>(theatre, HttpStatus.OK);
    }
}
