package com.AirplaneCoordinates.Features.Rotate;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class RotateInputDTO {
    public final PlanePoint point;
    public final CartesianPoint centerOfRotation;
    public final PreciseDecimal angle;

    public RotateInputDTO(
        final PlanePoint point,
        final CartesianPoint centerOfRotation,
        final PreciseDecimal angle
    ) {
        this.point = point;
        this.centerOfRotation = centerOfRotation;
        this.angle = angle;
    }
}
