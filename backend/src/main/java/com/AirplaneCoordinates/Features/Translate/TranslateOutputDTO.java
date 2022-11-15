package com.AirplaneCoordinates.Features.Translate;

import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class TranslateOutputDTO {
    public final PlanePoint point;

    public TranslateOutputDTO(final PlanePoint point) {
        this.point = point;
    }

    @Override
    public final String toString() {
        return "{ " +
            "point: " + this.point +
        " }";
    }
}
