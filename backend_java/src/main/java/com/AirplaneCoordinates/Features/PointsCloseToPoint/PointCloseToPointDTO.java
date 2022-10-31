package com.AirplaneCoordinates.Features.PointsCloseToPoint;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public class PointCloseToPointDTO {
    public final String id;
    public final PreciseDecimal distanceFromPoint;

    private PointCloseToPointDTO(
        final String id,
        final PreciseDecimal distanceFromPoint
    ) {
        this.id = id;
        this.distanceFromPoint = distanceFromPoint;
    }

    @Override
    public final String toString() {
        return "{ id: " + id + " , distanceFromPoint: " + distanceFromPoint + " }";
    }

    public static final PointCloseToPointDTO from(
        final String id,
        final PreciseDecimal distanceFromPoint
    ) {
        return new PointCloseToPointDTO(
            id,
            distanceFromPoint
        );
    }

    public static final PointCloseToPointDTO from(
        final String id,
        final String distanceFromPoint
    ) {
        return new PointCloseToPointDTO(
            id,
            PreciseDecimal.from(distanceFromPoint)
        );
    }
}