package com.github.erosb.etesdadokit.feature.planner;

import com.github.erosb.etesdadokit.feature.offer.transport.TransportOfferRequest;
import com.github.erosb.etesdadokit.feature.offer.transport.TransportOfferResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class PlannerController {

    @PostMapping("/planner/offers")
    @ApiOperation(
            value = "Creates a transport offer.",
            response = TransportOfferResponse.class
    )
    public ResponseEntity<String> offerTransport(@RequestBody @Valid TransportOfferRequest transportOfferRequest) {
        return ResponseEntity.ok(transportOfferRequest.toString());
    }
}
