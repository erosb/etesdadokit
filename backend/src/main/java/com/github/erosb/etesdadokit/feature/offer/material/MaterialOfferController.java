package com.github.erosb.etesdadokit.feature.offer.material;

import com.github.erosb.etesdadokit.configuration.SwaggerTags;
import com.github.erosb.etesdadokit.feature.offer.AcknowledgeResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/offer/material")
@Api(tags = { SwaggerTags.OFFER })
public class MaterialOfferController {

    @PostMapping("/")
    @ApiOperation(
            value = "Creates a material offer.",
            response = AcknowledgeResponse.class
    )
    public ResponseEntity<AcknowledgeResponse> offerMaterial(@RequestBody @Valid MaterialOfferRequest materialOfferRequest) {
        return ResponseEntity.ok(AcknowledgeResponse.builder().build());
    }

    @GetMapping
    @ApiOperation(
            value = "Return every material offer.",
            response = MaterialOfferResponse.class,
            responseContainer = "List"
    )
    public ResponseEntity<List<MaterialOfferResponse>> listMaterials(
        @ApiParam("The day for which the available material offers in yyyy-mm-dd format")
        @RequestParam(required = false) @Valid @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date day) {

        return ResponseEntity.ok(Collections.emptyList());
    }

}
