package com.github.erosb.etesdadokit.feature.planner;

import com.github.erosb.etesdadokit.configuration.SwaggerTags;
import com.github.erosb.etesdadokit.feature.offer.AcknowledgeResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/delivery-plan")
@Api(tags = {SwaggerTags.PLANNER})
public class DeliveryPlanController {

    private final DeliveryPlanService deliveryPlanService;

    public DeliveryPlanController(DeliveryPlanService deliveryPlanService) {
        this.deliveryPlanService = deliveryPlanService;
    }

    @GetMapping
    @ApiOperation(
            value = "Main page for planner",
            response = String.class
    )
    public ResponseEntity<List<DeliveryPlanResponse>> index() {
        return ResponseEntity.ok(deliveryPlanService.findAll());
    }

    @PostMapping
    public ResponseEntity<AcknowledgeResponse> createDeliveryPlan(@RequestBody @Valid DeliveryPlanRequest planRequest) {
        DeliveryPlanResponse response = deliveryPlanService.createDelivery(planRequest);
        Long id = response.getId();
        return ResponseEntity.ok(AcknowledgeResponse.builder().id(id).build());
    }
}
