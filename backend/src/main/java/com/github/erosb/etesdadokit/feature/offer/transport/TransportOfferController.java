package com.github.erosb.etesdadokit.feature.offer.transport;

import com.github.erosb.etesdadokit.configuration.SwaggerTags;
import com.github.erosb.etesdadokit.feature.offer.AcknowledgeResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/offer/transport")
@Api(tags = {SwaggerTags.OFFER})
public class TransportOfferController {

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    private final TransportOfferService transportOfferService;

    public TransportOfferController(TransportOfferService transportOfferService) {
        this.transportOfferService = transportOfferService;
    }

    @PostMapping
    @ApiOperation(
            value = "Creates a transport offer.",
            response = AcknowledgeResponse.class
    )
    public ResponseEntity<AcknowledgeResponse> offerTransport(@RequestBody @Valid TransportOfferRequest transportOfferRequest) {
        TransportOfferResponse response = transportOfferService.createTransportOffer(transportOfferRequest);
        Long id = response.getId();
        return ResponseEntity.ok(AcknowledgeResponse.builder().id(id).build());
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
        return ResponseEntity.ok(transportOfferService.listByDate(day));
    }

    @GetMapping("/date")
    @ApiOperation(
            value = "Get food offer by date.",
            response = TransportOfferResponse.class
    )
    public ResponseEntity<TransportOfferResponse> getTransportOfferByDate(
            @RequestParam(name = "date")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate transportDate) {
        return ResponseEntity.ok(transportOfferService.getTransportOfferByDate(transportDate));
    }

    @GetMapping("/page")
    @ApiOperation(
            value = "Return all transport offer paginated.",
            response = TransportOfferResponse.class,
            responseContainer = "List"
    )
    public ResponseEntity<TrasnsportOfferPagedList> listTransportOffersPaginated(
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", required = false) Integer pageSize
    ) {
        if (pageNumber == null || pageNumber < 0) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }

        if (pageSize == null || pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }

        return ResponseEntity.ok(transportOfferService.findAll(PageRequest.of(pageNumber, pageSize)));
    }

}
