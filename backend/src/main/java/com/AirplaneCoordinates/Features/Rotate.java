package com.AirplaneCoordinates.Features;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.Trigonometry.Deg;

public final class Rotate {
    private final PlanePoint point;
    private final CartesianPoint centerOfRotation;
    private final PreciseDecimal angle;

    public Rotate(
        final PlanePoint point,
        final CartesianPoint centerOfRotation,
        final PreciseDecimal angle
    ) {
        this.point = point;
        this.centerOfRotation = centerOfRotation;
        this.angle = angle;
    }

    public final PlanePoint execute() {
        final var angleValue = Deg.from(this.angle).normalized();
        final var offsetPoint = CartesianPoint.sub(this.point.toCartesian(), this.centerOfRotation);
        final var pointAsPolar = offsetPoint.toPolar();
        final var rotatedPoint = pointAsPolar.rotate(angleValue);
        final var pointAsCartesian = rotatedPoint.toCartesian();
        final var unoffsetedPoint = CartesianPoint.sum(pointAsCartesian, this.centerOfRotation);
    
        switch(this.point.planeType) {
            case CARTESIAN:
                return PlanePoint.fromCartesian(unoffsetedPoint.round());
            case POLAR:
                return PlanePoint.fromPolar(unoffsetedPoint.toPolar().round());
            default:
                throw new RuntimeException("planeType is required"); 
        }
    }
}
