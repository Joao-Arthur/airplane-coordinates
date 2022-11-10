package com.AirplaneCoordinates.Features;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class Translate {
    private final PlanePoint point;
    private final CartesianPoint factor;

    public Translate(
        final PlanePoint point,
        final CartesianPoint factor
    ) {
        this.point = point;
        this.factor = factor;
    }

    public final PlanePoint execute() {
        switch (this.point.planeType) {
            case CARTESIAN:
                return PlanePoint.fromCartesian(
                    CartesianPoint
                        .sum(
                            this.point.toCartesian(),
                            this.factor
                        )
                        .round()
                );
            case POLAR:
                return PlanePoint.fromPolar(
                    CartesianPoint
                        .sum(
                            this.point.toCartesian(),
                            this.factor
                        )
                        .toPolar()
                        .round()
                );
            default:
                throw new RuntimeException("planeType is required");
        }
    }
}
