package com.github.erosb.etesdadokit.feature.planner;

import com.github.erosb.etesdadokit.configuration.SwaggerTags;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery-plan")
@Api(tags = {SwaggerTags.PLANNER})
public class DeliveryPlanController {

    @GetMapping
    @ApiOperation(
            value = "Main page for planner",
            response = String.class

    )
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("ohai");
    }

    @PostMapping
    public ResponseEntity<String> createDeliveryPlan(@RequestBody DeliveryPlanRequest planRequest) {
        return ResponseEntity.ok().build();
    }
}
