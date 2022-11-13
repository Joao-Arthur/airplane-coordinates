package com.AirplaneCoordinates.Features.DTO;

import com.AirplaneCoordinates.Core.Mechanics.Vector;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class PlanePointWithVector {
    public final String id;
    public final PlanePoint point;
    public final Vector vector;

    public PlanePointWithVector(
        final String id,
        final PlanePoint point,
        final Vector vector
    ) {
        this.id = id;
        this.point = point;
        this.vector = vector;
    }

    @Override
    public final String toString() {
        return "{ " +
            "id: " + this.id + ", " +
            "point: " + this.point + ", " +
            "vector: " + this.vector +
        " }";
    }
}
