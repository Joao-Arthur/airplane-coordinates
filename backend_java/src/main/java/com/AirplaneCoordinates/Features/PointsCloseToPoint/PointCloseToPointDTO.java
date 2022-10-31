package com.AirplaneCoordinates.Features.PointsCloseToPoint;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public class PointCloseToPointDTO {
    public final String id;
    public final PreciseDecimal distanceFromPoint;

    public PointCloseToPointDTO(
        final String id,
        final PreciseDecimal distanceFromPoint
    ) {
        this.id = id;
        this.distanceFromPoint = distanceFromPoint;
    }
}
