package com.AirplaneCoordinates.Web.Arithmetic;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AirplaneCoordinates.Core.Logger.SystemLogger;

@RestController
@RequestMapping("arithmetic")
public final class ArithmeticController {
    private final ArithmeticGateway gateway;

    public ArithmeticController() {
        this.gateway = new ArithmeticGateway(new SystemLogger());
    }

    @PostMapping
    public final void translate() {
        return this.gateway.translate();
    }

    @PostMapping
    public final void scalonate() {
        return this.gateway.scalonate();
    }

    @PostMapping
    public final void rotate() {
        return this.gateway.rotate();
    }

    @PostMapping
    public final void pointsCloseToPoint() {
        return this.gateway.pointsCloseToPoint();
    }

    @PostMapping
    public final void pointsCloseToEachOther() {
        return this.gateway.pointsCloseToEachOther();
    }

    @PostMapping
    public final void pointsInRouteOfCollision() {
        return this.gateway.pointsInRouteOfCollision();
    }
}
