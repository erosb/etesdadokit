package com.github.erosb.etesdadokit.feature.offer.material;

import com.github.erosb.etesdadokit.feature.offer.AcknowledgeResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/offer/material")
public class MaterialOfferController {

    @PostMapping("/")
    @ApiOperation(
            value = "Creates a material offer.",
            response = AcknowledgeResponse.class
    )
    public ResponseEntity<AcknowledgeResponse> offerFood(@RequestBody @Valid MaterialOfferRequest materialOfferRequest) {
        return ResponseEntity.ok(AcknowledgeResponse.builder().build());
    }

    @GetMapping
    @ApiOperation(
            value = "Return every material offer.",
            response = MaterialOfferResponse.class,
            responseContainer = "List"
    )
    public ResponseEntity<List<MaterialOfferResponse>> offerMaterial() {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "Return a specific material offer.",
            response = MaterialOfferResponse.class
    )
    public ResponseEntity<MaterialOfferResponse> offerMaterial(@PathVariable String id) {
        return ResponseEntity.ok(MaterialOfferResponse.builder().build());
    }

}
