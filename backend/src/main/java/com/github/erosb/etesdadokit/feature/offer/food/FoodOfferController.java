package com.github.erosb.etesdadokit.feature.offer.food;

import com.github.erosb.etesdadokit.feature.offer.transport.TransportOfferResponse;
import com.github.erosb.etesdadokit.services.FoodOfferService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/offer/food")
public class FoodOfferController {

    private final FoodOfferService foodOfferService;

    public FoodOfferController(FoodOfferService foodOfferService) {
        this.foodOfferService = foodOfferService;
    }

    @PostMapping("/")
    @ApiOperation(
            value = "Creates a food offer.",
            response = TransportOfferResponse.class
    )
    public ResponseEntity<String> offerFood(@RequestBody @Valid FoodOfferRequest foodOfferRequest) {
        foodOfferService.createFoodOffer(foodOfferRequest);
        return ResponseEntity.ok(foodOfferRequest.toString());
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(
            value = "Shows all food offers.",
            response = TransportOfferResponse.class
    )
    public List<FoodOfferResponse> getAllFoodOffers() {
        foodOfferService.getAllFoodOfferings();
        return foodOfferService.getAllFoodOfferings();
    }
}
