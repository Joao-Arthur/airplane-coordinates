package com.AirplaneCoordinates.Web.Arithmetic;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AirplaneCoordinates.Core.Logger.SystemLogger;
import com.AirplaneCoordinates.Features.PointsCloseToEachOther.PointsCloseToEachOtherOutputDTO;
import com.AirplaneCoordinates.Features.PointsCloseToPoint.PointsCloseToPointOutputDTO;
import com.AirplaneCoordinates.Features.PointsInRouteOfCollision.PointsInRouteOfCollisionOutputDTO;
import com.AirplaneCoordinates.Features.Rotate.RotateOutputDTO;
import com.AirplaneCoordinates.Features.Scalonate.ScalonateOutputDTO;
import com.AirplaneCoordinates.Features.Translate.TranslateOutputDTO;
import com.AirplaneCoordinates.Plain.Features.PointsCloseToEachOther.PointsCloseToEachOtherInputDTOPlain;
import com.AirplaneCoordinates.Plain.Features.PointsCloseToPoint.PointsCloseToPointInputDTOPlain;
import com.AirplaneCoordinates.Plain.Features.PointsInRouteOfCollision.PointsInRouteOfCollisionInputDTOPlain;
import com.AirplaneCoordinates.Plain.Features.Rotate.RotateInputDTOPlain;
import com.AirplaneCoordinates.Plain.Features.Scalonate.ScalonateInputDTOPlain;
import com.AirplaneCoordinates.Plain.Features.Translate.TranslateInputDTOPlain;

@RestController
@RequestMapping("arithmetic")
@CrossOrigin(origins = "*")
public final class ArithmeticController {
    private final ArithmeticGateway gateway;

    public ArithmeticController() {
        this.gateway = new ArithmeticGateway(new SystemLogger());
    }

    @PostMapping("translate")
    public final TranslateOutputDTO translate(
        @RequestBody
        final TranslateInputDTOPlain params
    ) {
        return this.gateway.translate(params.toObject());
    }

    @PostMapping("scalonate")
    public final ScalonateOutputDTO scalonate(
        @RequestBody
        final ScalonateInputDTOPlain params
    ) {
        return this.gateway.scalonate(params.toObject());
    }

    @PostMapping("rotate")
    public final RotateOutputDTO rotate(
        @RequestBody
        final RotateInputDTOPlain params
    ) {
        return this.gateway.rotate(params.toObject());
    }

    @PostMapping("closeToPoint")
    public final PointsCloseToPointOutputDTO pointsCloseToPoint(
        @RequestBody
        final PointsCloseToPointInputDTOPlain params
    ) {
        return this.gateway.pointsCloseToPoint(params.toObject());
    }

    @PostMapping("closeToEachOther")
    public final PointsCloseToEachOtherOutputDTO pointsCloseToEachOther(
        @RequestBody
        final PointsCloseToEachOtherInputDTOPlain params
    ) {
        return this.gateway.pointsCloseToEachOther(params.toObject());
    }

    @PostMapping("routeOfCollision")
    public final PointsInRouteOfCollisionOutputDTO pointsInRouteOfCollision(
        @RequestBody
        final PointsInRouteOfCollisionInputDTOPlain params
    ) {
        return this.gateway.pointsInRouteOfCollision(params.toObject());
    }
}
