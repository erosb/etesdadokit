package com.github.erosb.etesdadokit.feature.offer.transport;

import com.github.erosb.etesdadokit.configuration.SwaggerTags;
import com.github.erosb.etesdadokit.feature.offer.AcknowledgeResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    public ResponseEntity<List<TransportOfferResponse>> offerTransport(
            @RequestParam(required = false) @Valid @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date day) {
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/{id}")
    @ApiOperation(
            value = "Return a specific transport offer.",
            response = TransportOfferResponse.class
    )
    public ResponseEntity<TransportOfferResponse> offerTransport(@PathVariable String id) {
        return ResponseEntity.ok(TransportOfferResponse.builder().build());
    }

}
