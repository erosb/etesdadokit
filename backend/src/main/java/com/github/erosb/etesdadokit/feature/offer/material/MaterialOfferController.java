package com.github.erosb.etesdadokit.feature.offer.material;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/offer/material")
public class MaterialOfferController {

    @PostMapping("/")
    @ApiOperation(
            value = "Creates a material offer.",
            response = MaterialOfferRequest.class
    )
    public ResponseEntity<MaterialOfferResponse> offerFood(@RequestBody @Valid MaterialOfferRequest materialOfferRequest) {
        return ResponseEntity.ok(MaterialOfferResponse.builder().build());
    }
}
