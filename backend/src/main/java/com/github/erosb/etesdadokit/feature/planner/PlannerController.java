package com.github.erosb.etesdadokit.feature.planner;

import com.github.erosb.etesdadokit.configuration.SwaggerTags;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/planner")
@Api(tags = {SwaggerTags.PLANNER})
public class PlannerController {

    @GetMapping
    @ApiOperation(
            value = "Main page for planner",
            response = String.class

    )
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("ohai");
    }
}
