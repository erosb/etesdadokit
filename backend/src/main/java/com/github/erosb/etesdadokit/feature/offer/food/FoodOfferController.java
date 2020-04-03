package com.github.erosb.etesdadokit.feature.offer.food;

import com.github.erosb.etesdadokit.feature.offer.transport.TransportOfferResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/offer/food")
public class FoodOfferController {

    @PostMapping("/")
    @ApiOperation(
            value = "Creates a food offer.",
            response = TransportOfferResponse.class
    )
    public ResponseEntity<String> offerFood(@RequestBody @Valid FoodOfferRequest foodOfferRequest) {
        return ResponseEntity.ok(foodOfferRequest.toString());
    }
}
