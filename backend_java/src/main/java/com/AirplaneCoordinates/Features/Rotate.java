package com.AirplaneCoordinates.Features;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianOperations;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Conversion.PlaneConversion;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.Trigonometry.Trigonometry;

public final class Rotate {
    public static PlanePoint execute(
        final PlanePoint point,
        final CartesianPoint centerOfRotation,
        final PreciseDecimal angle
    ) {
        final var angleValue = Trigonometry.normalizeAngle(angle);
        final var offsetPoint = CartesianOperations.sub(point.toCartesian(), centerOfRotation);
        final var pointAsPolar = PlaneConversion.cartesianToPolar(offsetPoint);
        final var rotatedPoint = pointAsPolar.rotate(angleValue);
        final var pointAsCartesian = PlaneConversion.polarToCartesian(rotatedPoint);
        final var unoffsetedPoint = CartesianOperations.sum(pointAsCartesian, centerOfRotation);
    
        switch(point.planeType) {
            case CARTESIAN:
                return PlanePoint.fromCartesian(unoffsetedPoint);
            case POLAR:
                final var unoffsetedAsPolar = PlaneConversion.cartesianToPolar(unoffsetedPoint);
    
                return PlanePoint.fromPolar(unoffsetedAsPolar);
            default:
                throw new RuntimeException("planeType is required"); 
        }
    }
}
