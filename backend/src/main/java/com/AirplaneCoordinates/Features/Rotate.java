package com.AirplaneCoordinates.Features;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianOperations;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.Trigonometry.Deg;

public final class Rotate {
    public static PlanePoint execute(
        final PlanePoint point,
        final CartesianPoint centerOfRotation,
        final PreciseDecimal angle
    ) {
        final var angleValue = Deg.from(angle).normalized();
        final var offsetPoint = CartesianOperations.sub(point.toCartesian(), centerOfRotation);
        final var pointAsPolar = offsetPoint.toPolar();
        final var rotatedPoint = pointAsPolar.rotate(angleValue);
        final var pointAsCartesian = rotatedPoint.toCartesian();
        final var unoffsetedPoint = CartesianOperations.sum(pointAsCartesian, centerOfRotation);
    
        switch(point.planeType) {
            case CARTESIAN:
                return PlanePoint.fromCartesian(unoffsetedPoint.round());
            case POLAR:
                return PlanePoint.fromPolar(unoffsetedPoint.toPolar().round());
            default:
                throw new RuntimeException("planeType is required"); 
        }
    }
}
