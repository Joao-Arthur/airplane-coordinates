package com.AirplaneCoordinates.Web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")
public final class HealthcheckController {
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public final void healthcheck() { }
}
