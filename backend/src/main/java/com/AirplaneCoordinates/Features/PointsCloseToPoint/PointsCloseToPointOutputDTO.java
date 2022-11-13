package com.AirplaneCoordinates.Features.PointsCloseToPoint;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PointsCloseToPointOutputDTO {
    public final String id;
    public final PreciseDecimal distanceFromPoint;

    public PointsCloseToPointOutputDTO(
        final String id,
        final PreciseDecimal distanceFromPoint
    ) {
        this.id = id;
        this.distanceFromPoint = distanceFromPoint;
    }

    @Override
    public final String toString() {
        return "{ " +
            "id: " + this.id + ", " +
            "distanceFromPoint: " + this.distanceFromPoint + 
        " }";
    }
}
