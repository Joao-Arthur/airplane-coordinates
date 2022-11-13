package com.AirplaneCoordinates.Features.PointsCloseToPoint;

import java.util.List;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class PointsCloseToPointInputDTO {
    public final List<PlanePointWithId> points;
    public final PreciseDecimal maxDistance;

    public PointsCloseToPointInputDTO(
        final List<PlanePointWithId> points,
        final PreciseDecimal maxDistance
    ) {
        this.points = points;
        this.maxDistance = maxDistance;
    }

    @Override
    public final String toString() {
        return "{ " +

        " }";
    }
}
