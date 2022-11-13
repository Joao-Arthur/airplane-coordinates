package com.AirplaneCoordinates.Features.Scalonate;

import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public class ScalonateOutputDTO {
    public final PlanePoint point;

    public ScalonateOutputDTO(final PlanePoint point) {
        this.point = point;
    }

    @Override
    public final String toString() {
        return "{ " +
            "point: " + this.point +
        " }";
    }
}
