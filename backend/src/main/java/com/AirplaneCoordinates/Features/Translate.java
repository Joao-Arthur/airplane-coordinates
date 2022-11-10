package com.AirplaneCoordinates.Features;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class Translate {
    public static PlanePoint execute(final PlanePoint point, final CartesianPoint factor) {
        switch (point.planeType) {
            case CARTESIAN:
                return PlanePoint.fromCartesian(
                    CartesianPoint.sum(
                        point.toCartesian(),
                        factor
                    ).round()
                );
            case POLAR:
                return PlanePoint.fromPolar(
                    CartesianPoint.sum(
                        point.toCartesian(),
                        factor
                    ).toPolar().round()
                );
            default:
                throw new RuntimeException("planeType is required");
        }
    }
}
