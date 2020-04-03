package com.github.erosb.etesdadokit.feature.offer.transport;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/offer/transport")
public class TransportOfferController {

    @PostMapping
    @ApiOperation(
            value = "Creates a transport offer.",
            response = TransportOfferResponse.class
    )
    public ResponseEntity<TransportOfferResponse> offerTransport(@RequestBody @Valid TransportOfferRequest transportOfferRequest) {
        return ResponseEntity.ok(TransportOfferResponse.builder().build());
    }

    @GetMapping
    @ApiOperation(
            value = "Return every transport offer.",
            response = TransportOfferResponse.class,
            responseContainer = "List"
    )
    public ResponseEntity<List<TransportOfferResponse>> offerTransport() {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "Return the given transport offer.",
            response = TransportOfferResponse.class
    )
    public ResponseEntity<TransportOfferResponse> offerTransport(@RequestParam String id) {
        return ResponseEntity.ok(TransportOfferResponse.builder().build());
    }

}
