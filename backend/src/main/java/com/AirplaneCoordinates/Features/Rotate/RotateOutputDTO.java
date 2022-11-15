package com.AirplaneCoordinates.Features.Rotate;

import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class RotateOutputDTO {
    public final PlanePoint point;

    public RotateOutputDTO(final PlanePoint point) {
        this.point = point;
    }

    @Override
    public final String toString() {
        return "{ " +
            "point: " + this.point +
        " }";
    }
}
