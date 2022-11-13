package com.AirplaneCoordinates.Web.Arithmetic;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AirplaneCoordinates.Core.Logger.SystemLogger;
import com.AirplaneCoordinates.Features.PointsCloseToEachOther.*;
import com.AirplaneCoordinates.Features.PointsCloseToPoint.*;
import com.AirplaneCoordinates.Features.PointsInRouteOfCollision.*;
import com.AirplaneCoordinates.Features.Rotate.*;
import com.AirplaneCoordinates.Features.Scalonate.*;
import com.AirplaneCoordinates.Features.Translate.*;

@RestController
@RequestMapping("arithmetic")
public final class ArithmeticController {
    private final ArithmeticGateway gateway;

    public ArithmeticController() {
        this.gateway = new ArithmeticGateway(new SystemLogger());
    }

    @PostMapping
    public final TranslateOutputDTO translate(
        final TranslateInputDTO params
    ) {
        return this.gateway.translate(params);
    }

    @PostMapping
    public final ScalonateOutputDTO scalonate(
        final ScalonateInputDTO params
    ) {
        return this.gateway.scalonate(params);
    }

    @PostMapping
    public final RotateOutputDTO rotate(
        final RotateInputDTO params
    ) {
        return this.gateway.rotate(params);
    }

    @PostMapping
    public final PointsCloseToPointOutputDTO pointsCloseToPoint(
        final PointsCloseToPointInputDTO params
    ) {
        return this.gateway.pointsCloseToPoint(params);
    }

    @PostMapping
    public final PointsCloseToEachOtherOutputDTO pointsCloseToEachOther(
        final PointsCloseToEachOtherInputDTO params
    ) {
        return this.gateway.pointsCloseToEachOther(params);
    }

    @PostMapping
    public final PointsInRouteOfCollisionOutputDTO pointsInRouteOfCollision(
        final PointsInRouteOfCollisionInputDTO params
    ) {
        return this.gateway.pointsInRouteOfCollision(params);
    }
}
