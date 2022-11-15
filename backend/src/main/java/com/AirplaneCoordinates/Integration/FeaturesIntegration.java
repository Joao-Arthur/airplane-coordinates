package com.AirplaneCoordinates.Integration;

import com.AirplaneCoordinates.Core.Logger.Logger;
import com.AirplaneCoordinates.Features.PointsCloseToEachOther.PointsCloseToEachOtherService;
import com.AirplaneCoordinates.Features.PointsCloseToPoint.PointsCloseToPointService;
import com.AirplaneCoordinates.Features.PointsInRouteOfCollision.PointsInRouteOfCollisionService;
import com.AirplaneCoordinates.Features.Rotate.RotateService;
import com.AirplaneCoordinates.Features.Scalonate.ScalonateService;
import com.AirplaneCoordinates.Features.Translate.TranslateService;
import com.AirplaneCoordinates.Plain.Features.PointsCloseToEachOther.PointsCloseToEachOtherInputDTOPlain;
import com.AirplaneCoordinates.Plain.Features.PointsCloseToEachOther.PointsCloseToEachOtherOutputDTOPlain;
import com.AirplaneCoordinates.Plain.Features.PointsCloseToPoint.PointsCloseToPointInputDTOPlain;
import com.AirplaneCoordinates.Plain.Features.PointsCloseToPoint.PointsCloseToPointOutputDTOPlain;
import com.AirplaneCoordinates.Plain.Features.PointsInRouteOfCollision.PointsInRouteOfCollisionInputDTOPlain;
import com.AirplaneCoordinates.Plain.Features.PointsInRouteOfCollision.PointsInRouteOfCollisionOutputDTOPlain;
import com.AirplaneCoordinates.Plain.Features.Rotate.RotateInputDTOPlain;
import com.AirplaneCoordinates.Plain.Features.Rotate.RotateOutputDTOPlain;
import com.AirplaneCoordinates.Plain.Features.Scalonate.ScalonateInputDTOPlain;
import com.AirplaneCoordinates.Plain.Features.Scalonate.ScalonateOutputDTOPlain;
import com.AirplaneCoordinates.Plain.Features.Translate.TranslateInputDTOPlain;
import com.AirplaneCoordinates.Plain.Features.Translate.TranslateOutputDTOPlain;

public final class FeaturesIntegration {
    private final Logger logger;

    public FeaturesIntegration(final Logger logger) {
        this.logger = logger;
    }

    private final void logHeader(final String methodName) {
        this.logger.separator();
        this.logger.logWithDate("Executing " + methodName);
    }

    private final void logInput(final String input) {
        this.logger.log("Input: " + input);
    }

    private final void logOutput(final String output) {
        this.logger.log("Output: " + output);
    }

    public final TranslateOutputDTOPlain translate(
        final TranslateInputDTOPlain params
    ) {
        final var paramsObject = params.toObject();
        this.logHeader("translate");
        this.logInput(paramsObject.toString());
        final var result = new TranslateService(paramsObject).execute();
        this.logOutput(result.toString());
        return TranslateOutputDTOPlain.fromObject(result);
    }

    public final ScalonateOutputDTOPlain scalonate(
        final ScalonateInputDTOPlain params
    ) {
        final var paramsObject = params.toObject();
        this.logHeader("scalonate");
        this.logInput(paramsObject.toString());
        final var result = new ScalonateService(paramsObject).execute();
        this.logOutput(result.toString());
        return ScalonateOutputDTOPlain.fromObject(result);
    }

    public final RotateOutputDTOPlain rotate(
        final RotateInputDTOPlain params
    ) {
        final var paramsObject = params.toObject();
        this.logHeader("rotate");
        this.logInput(paramsObject.toString());
        final var result = new RotateService(paramsObject).execute();
        this.logOutput(result.toString());
        return RotateOutputDTOPlain.fromObject(result);
    }

    public final PointsCloseToPointOutputDTOPlain pointsCloseToPoint(
        final PointsCloseToPointInputDTOPlain params
    ) {
        final var paramsObject = params.toObject();
        this.logHeader("pointsCloseToPoint");
        this.logInput(paramsObject.toString());
        final var result = new PointsCloseToPointService(paramsObject).execute();
        this.logOutput(result.toString());
        return PointsCloseToPointOutputDTOPlain.fromObject(result);
    }

    public final PointsCloseToEachOtherOutputDTOPlain pointsCloseToEachOther(
        final PointsCloseToEachOtherInputDTOPlain params
    ) {
        final var paramsObject = params.toObject();
        this.logHeader("pointsCloseToEachOther");
        this.logInput(paramsObject.toString());
        final var result = new PointsCloseToEachOtherService(paramsObject).execute();
        this.logOutput(result.toString());
        return PointsCloseToEachOtherOutputDTOPlain.fromObject(result);
    }

    public final PointsInRouteOfCollisionOutputDTOPlain pointsInRouteOfCollision(
        final PointsInRouteOfCollisionInputDTOPlain params
    ) {
        final var paramsObject = params.toObject();
        this.logHeader("pointsInRouteOfCollision");
        this.logInput(paramsObject.toString());
        final var result = new PointsInRouteOfCollisionService(paramsObject).execute();
        this.logOutput(result.toString());
        return PointsInRouteOfCollisionOutputDTOPlain.fromObject(result);
    }
}
