package com.AirplaneCoordinates.Features.Scalonate;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class ScalonateInputDTO {
    public final PlanePoint point;
    public final CartesianPoint factor;

    public ScalonateInputDTO(
        final PlanePoint point,
        final CartesianPoint factor
    ) {
        this.point = point;
        this.factor = factor;
    }

    @Override
    public final String toString() {
        return "{ " +
            "point: " + this.point + ", " +
            "factor: " + this.factor +
        " }";
    }
}
