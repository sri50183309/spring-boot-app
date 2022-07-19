package com.sapient.xyz.bookingapp.theatre;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/xyz/theatre")
public class TheatreController {

    @GetMapping(value = "/{theatreid}", produces = "application/json")
    public ResponseEntity<Theatre> list (@PathVariable("theatreid")  int theatreId) {
        return new ResponseEntity<>(new Theatre(), HttpStatus.OK);
    }
}
