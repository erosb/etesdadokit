package com.github.erosb.etesdadokit.feature.offer.food;

import com.github.erosb.etesdadokit.feature.offer.AcknowledgeResponse;
import com.github.erosb.etesdadokit.services.FoodOfferService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            response = AcknowledgeResponse.class
    )
    public ResponseEntity<AcknowledgeResponse> offerFood(@RequestBody @Valid FoodOfferRequest foodOfferRequest) {
        foodOfferService.createFoodOffer(foodOfferRequest);
        return ResponseEntity.ok(AcknowledgeResponse.builder().build());
    }

    @GetMapping
    @ApiOperation(
            value = "Return every food offer.",
            response = FoodOfferResponse.class,
            responseContainer = "List"
    )
    public ResponseEntity<List<FoodOfferResponse>> getAllFoodOffers() {
        return ResponseEntity.ok(foodOfferService.getAllFoodOfferings());
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "Return a specific food offer.",
            response = FoodOfferResponse.class
    )
    public ResponseEntity<FoodOfferResponse> foodOffer(@PathVariable String id) {
        return ResponseEntity.ok(FoodOfferResponse.builder().build());
    }

}
