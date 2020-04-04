package com.github.erosb.etesdadokit.feature.offer.transport;

import com.github.erosb.etesdadokit.configuration.SwaggerTags;
import com.github.erosb.etesdadokit.feature.offer.AcknowledgeResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/offer/transport")
@Api(tags = {SwaggerTags.OFFER})
public class TransportOfferController {

    @PostMapping
    @ApiOperation(
            value = "Creates a transport offer.",
            response = AcknowledgeResponse.class
    )
    public ResponseEntity<AcknowledgeResponse> offerTransport(@RequestBody @Valid TransportOfferRequest transportOfferRequest) {
        return ResponseEntity.ok(AcknowledgeResponse.builder().build());
    }

    @GetMapping
    @ApiOperation(
            value = "Return every transport offer.",
            response = TransportOfferResponse.class,
            responseContainer = "List"
    )
    public ResponseEntity<List<TransportOfferResponse>> listTransportOffers(
            @ApiParam("The day for which the available transport offers in yyyy-mm-dd format")
            @RequestParam(required = false) @Valid @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate day) {
        return ResponseEntity.ok(Collections.emptyList());
    }

}
