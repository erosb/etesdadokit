package com.github.erosb.etesdadokit.feature.index;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/")
    @ApiOperation(
            value = "Home page placeholder."
    )
    public ResponseEntity<String> index() {
        return ResponseEntity.ok("");
    }
}
