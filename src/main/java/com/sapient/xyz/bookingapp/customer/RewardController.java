package com.sapient.xyz.bookingapp.customer;

import com.sapient.xyz.bookingapp.model.Theatre;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/xyz/rewards")
public class RewardController {
    @GetMapping(value = "/", produces = "application/json")
    @ApiOperation(value = "Returns all rewards", notes = "Listing available rewards")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success", response = Map.class),
                    @ApiResponse(code = 400, message = "Success", response = Map.class),
                    @ApiResponse(code = 401, message = "Success", response = Map.class),
                    @ApiResponse(code = 404, message = "Success", response = Map.class),
                    @ApiResponse(code = 500, message = "Success", response = Map.class),
                    @ApiResponse(code = 0, message = "Success", response = Map.class)
            }
    )
    public ResponseEntity<Map<String,String>> findAllRewards () {
        Map<String, String> rewardsMap = new HashMap<>();
        rewardsMap.put("All cities", "50% discount on the third ticket");
        rewardsMap.put("In Cities", "Tickets booked for the afternoon show get a 20% discount");
        return new ResponseEntity<>(rewardsMap, HttpStatus.OK);
    }
}
