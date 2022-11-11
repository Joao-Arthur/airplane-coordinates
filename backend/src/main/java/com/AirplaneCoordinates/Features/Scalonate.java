package com.AirplaneCoordinates.Features;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class Scalonate {
    private final PlanePoint point;
    private final CartesianPoint factor;

    public Scalonate(
        final PlanePoint point,
        final CartesianPoint factor
    ) {
        this.point = point;
        this.factor = factor;
    }

    public final PlanePoint execute() {
        final var resultPoint = this.point
            .toCartesian()
            .times(this.factor);

        switch (this.point.planeType) {
            case CARTESIAN:
                return PlanePoint.fromCartesian(
                    resultPoint.round()
                );
            case POLAR:
                return PlanePoint.fromPolar(
                    resultPoint.toPolar().round()
                );
            default:
                throw new RuntimeException("planeType is required");
        }
    }
}
