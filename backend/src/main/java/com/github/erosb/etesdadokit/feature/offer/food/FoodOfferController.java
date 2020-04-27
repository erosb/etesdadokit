package com.github.erosb.etesdadokit.feature.offer.food;

import com.github.erosb.etesdadokit.configuration.SwaggerTags;
import com.github.erosb.etesdadokit.feature.offer.AcknowledgeResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/offer/food")
@Api(tags = {SwaggerTags.OFFER})
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
        FoodOfferResponse response = foodOfferService.createFoodOffer(foodOfferRequest);
        Long id = response.getId();
        return ResponseEntity.ok(AcknowledgeResponse.builder().id(id).build());
    }

    @GetMapping
    @ApiOperation(
            value = "Return every food offer.",
            response = FoodOfferResponse.class,
            responseContainer = "List"
    )
    public ResponseEntity<List<FoodOfferResponse>> listFoodOffers(
            @ApiParam("The day for which the available food offers should be returned in yyyy-mm-dd format")
            @RequestParam(required = false) @Valid @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate day) {

        return ResponseEntity.ok(foodOfferService.listFoodOfferings(day));
    }

    @GetMapping("{id}")
    @ApiOperation(
            value = "Get food offer by id.",
            response = FoodOfferResponse.class
    )
    public ResponseEntity<FoodOfferResponse> getFoodOfferById(@PathVariable Long id) {
        return ResponseEntity.ok(foodOfferService.getById(id));
    }

    @GetMapping("/getByIngredient")
    public ResponseEntity<List<FoodOfferResponse>> getFoodOffersByIngredient(@RequestBody String ingredient) {
        return ResponseEntity.ok(foodOfferService.getFoodOffersByIngredient(ingredient));

    }

}
