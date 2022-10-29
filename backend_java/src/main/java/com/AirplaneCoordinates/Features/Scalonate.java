package com.AirplaneCoordinates.Features;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianOperations;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Conversion.PlaneConversion;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class Scalonate {
    public static PlanePoint execute(final PlanePoint point, final CartesianPoint factor) {
        switch (point.planeType) {
            case CARTESIAN:
                return PlanePoint.fromCartesian(
                    CartesianOperations.mul(
                        point.toCartesian(),
                        factor
                    ).round()
                );
            case POLAR:
                return PlanePoint.fromPolar(
                    PlaneConversion.cartesianToPolar(
                        CartesianOperations.mul(
                            point.toCartesian(),
                            factor
                        )
                    ).round()
                );
            default:
                throw new RuntimeException("planeType is required");
        }
    }
}
