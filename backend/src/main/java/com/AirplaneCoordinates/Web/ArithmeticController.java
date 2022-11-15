package com.AirplaneCoordinates.Web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AirplaneCoordinates.Core.Logger.SystemLogger;
import com.AirplaneCoordinates.Integration.FeaturesIntegration;
import com.AirplaneCoordinates.Plain.Features.Translate.*;
import com.AirplaneCoordinates.Plain.Features.Scalonate.*;
import com.AirplaneCoordinates.Plain.Features.Rotate.*;
import com.AirplaneCoordinates.Plain.Features.PointsCloseToEachOther.*;
import com.AirplaneCoordinates.Plain.Features.PointsCloseToPoint.*;
import com.AirplaneCoordinates.Plain.Features.PointsInRouteOfCollision.*;

@RestController
@RequestMapping("arithmetic")
@CrossOrigin(origins = "*")
public final class ArithmeticController {
    private final FeaturesIntegration integration;

    public ArithmeticController() {
        this.integration = new FeaturesIntegration(new SystemLogger());
    }

    @PostMapping("translate")
    public final TranslateOutputDTOPlain translate(
        @RequestBody
        final TranslateInputDTOPlain params
    ) {
        return this.integration.translate(params);
    }

    @PostMapping("scalonate")
    public final ScalonateOutputDTOPlain scalonate(
        @RequestBody
        final ScalonateInputDTOPlain params
    ) {
        return this.integration.scalonate(params);
    }

    @PostMapping("rotate")
    public final RotateOutputDTOPlain rotate(
        @RequestBody
        final RotateInputDTOPlain params
    ) {
        return this.integration.rotate(params);
    }

    @PostMapping("closeToPoint")
    public final PointsCloseToPointOutputDTOPlain pointsCloseToPoint(
        @RequestBody
        final PointsCloseToPointInputDTOPlain params
    ) {
        return this.integration.pointsCloseToPoint(params);
    }

    @PostMapping("closeToEachOther")
    public final PointsCloseToEachOtherOutputDTOPlain pointsCloseToEachOther(
        @RequestBody
        final PointsCloseToEachOtherInputDTOPlain params
    ) {
        return this.integration.pointsCloseToEachOther(params);
    }

    @PostMapping("routeOfCollision")
    public final PointsInRouteOfCollisionOutputDTOPlain pointsInRouteOfCollision(
        @RequestBody
        final PointsInRouteOfCollisionInputDTOPlain params
    ) {
        return this.integration.pointsInRouteOfCollision(params);
    }
}
