package com.AirplaneCoordinates.Core.Mechanics;

import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class PlaneVector {
    public final PlanePoint point;
    public final Vector vector;

    public PlaneVector(
        final PlanePoint point,
        final Vector vector
    ) {
        this.point = point;
        this.vector = vector;
    }

    @Override
    public final String toString() {
        return "{ " +
            "point: " + this.point.toString() + ", " +
            "vector: " + this.vector.toString() +
        " }";
    }
}
