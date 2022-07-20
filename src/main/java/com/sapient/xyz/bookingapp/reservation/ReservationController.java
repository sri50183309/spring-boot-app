package com.sapient.xyz.bookingapp.reservation;

import com.sapient.xyz.bookingapp.domain.ReservationInfo;
import com.sapient.xyz.bookingapp.model.MovieRunningInTheatre;
import com.sapient.xyz.bookingapp.model.Reservation;
import com.sapient.xyz.bookingapp.model.Theatre;
import com.sapient.xyz.bookingapp.repository.MovingRunningInTheatreRepository;
import com.sapient.xyz.bookingapp.repository.ReservationRespository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/xyz/reserve")
public class ReservationController {

    @Autowired
    ReservationRespository reservationRespository;

    @Autowired
    MovingRunningInTheatreRepository movingRunningInTheatreRepository;

    @PostMapping(value = "/", produces = "application/json")
    @ApiOperation(value = "Creates a reservation", notes = "Add new reservation")
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
    public ResponseEntity<Reservation> create (@RequestBody ReservationInfo reservationInfo) {
       Long id= movingRunningInTheatreRepository.findMovingRunningInTheatreByTheatreNameAndMovieName(reservationInfo.getTheatreName(),
                                                                                    reservationInfo.getMovieName(),
                                                                                    reservationInfo.getShows_times());

        Reservation reservation = new Reservation();
        reservation.setMoviesRunningInTheatre(movingRunningInTheatreRepository.findById(id).get());
        reservation.setCustomer_name(reservationInfo.getCustomerName());
        reservation.setSeat_pref(reservationInfo.getSeatPref());
        return new ResponseEntity<>(reservationRespository.save(reservation), HttpStatus.OK);
    }

    @GetMapping(value = "/{reservationid}", produces = "application/json")
    @ApiOperation(value = "Find a reservation by id", notes = "Find reservation")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success", response = Reservation.class),
                    @ApiResponse(code = 400, message = "Success", response = Reservation.class),
                    @ApiResponse(code = 401, message = "Success", response = Reservation.class),
                    @ApiResponse(code = 404, message = "Success", response = Reservation.class),
                    @ApiResponse(code = 500, message = "Success", response = Reservation.class),
                    @ApiResponse(code = 0, message = "Success", response = Reservation.class)
            }
    )
    public ResponseEntity<Reservation> getReservation (@PathVariable("reservationid") @Valid @ApiParam(required = true, example = "1" , allowableValues = "range[0,999999]")   int reservationId) {
        Optional<Reservation> reservation = reservationRespository.findById(new Long(reservationId));
        if(reservation.isPresent())
            return new ResponseEntity<>(reservation.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    }
}
