package com.AirplaneCoordinates.Features.DTO;

import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class PlanePointWithId {
    public final String id;
    public final PlanePoint point;

    private PlanePointWithId(
        final String id,
        final PlanePoint point
    ) {
        this.id = id;
        this.point = point;
    }

    @Override
    public final String toString() {
        return "{ " +
            "id: " + this.id + ", " +
            "point: " + this.point.toString() +
        " }";
    }

    public static final PlanePointWithId from(
        final String id,
        final PlanePoint point
    ) {
        return new PlanePointWithId(
            id,
            point
        );
    }
}
