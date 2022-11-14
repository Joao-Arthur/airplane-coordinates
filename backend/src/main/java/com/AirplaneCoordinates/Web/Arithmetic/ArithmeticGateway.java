package com.AirplaneCoordinates.Web.Arithmetic;

import com.AirplaneCoordinates.Core.Logger.Logger;
import com.AirplaneCoordinates.Features.PointsCloseToEachOther.*;
import com.AirplaneCoordinates.Features.PointsCloseToPoint.*;
import com.AirplaneCoordinates.Features.PointsInRouteOfCollision.*;
import com.AirplaneCoordinates.Features.Rotate.*;
import com.AirplaneCoordinates.Features.Scalonate.*;
import com.AirplaneCoordinates.Features.Translate.*;

public final class ArithmeticGateway {
    private final Logger logger;

    public ArithmeticGateway(final Logger logger) {
        this.logger = logger;
    }

    private final void logHeader(final String methodName) {
        this.logger.separator();
        this.logger.logWithDate("Executing " + methodName);
        this.logger.subSeparator();
    }

    private final void logInput(final String input) {
        this.logger.log("Input: " + input);
    }

    private final void logOutput(final String output) {
        this.logger.log("Output: " + output);
    }

    public final TranslateOutputDTO translate(
        final TranslateInputDTO params
    ) {
        this.logHeader("translate");
        this.logInput(params.toString());
        final var result = new TranslateService(params).execute();
        this.logOutput(result.toString());
        return result;
    }

    public final ScalonateOutputDTO scalonate(
        final ScalonateInputDTO params
    ) {
        this.logHeader("scalonate");
        this.logInput(params.toString());
        final var result = new ScalonateService(params).execute();
        this.logOutput(result.toString());
        return result;
    }

    public final RotateOutputDTO rotate(
        final RotateInputDTO params
    ) {
        this.logHeader("rotate");
        this.logInput(params.toString());
        final var result = new RotateService(params).execute();
        this.logOutput(result.toString());
        return result;
    }

    public final PointsCloseToPointOutputDTO pointsCloseToPoint(
        final PointsCloseToPointInputDTO params
    ) {
        this.logHeader("pointsCloseToPoint");
        this.logInput(params.toString());
        final var result = new PointsCloseToPointService(params).execute();
        this.logOutput(result.toString());
        return result;
    }

    public final PointsCloseToEachOtherOutputDTO pointsCloseToEachOther(
        final PointsCloseToEachOtherInputDTO params
    ) {
        this.logHeader("pointsCloseToEachOther");
        this.logInput(params.toString());
        final var result = new PointsCloseToEachOtherService(params).execute();
        this.logOutput(result.toString());
        return result;
    }

    public final PointsInRouteOfCollisionOutputDTO pointsInRouteOfCollision(
        final PointsInRouteOfCollisionInputDTO params
    ) {
        this.logHeader("pointsInRouteOfCollision");
        this.logInput(params.toString());
        final var result = new PointsInRouteOfCollisionService(params).execute();
        this.logOutput(result.toString());
        return result;
    }
}
