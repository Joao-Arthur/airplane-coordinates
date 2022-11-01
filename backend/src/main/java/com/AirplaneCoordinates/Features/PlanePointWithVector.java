package com.AirplaneCoordinates.Features;

import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PlanePointWithVector {
    public final String id;
    public final PlanePoint point;
    public final PreciseDecimal direction;
    public final PreciseDecimal speed;

    private PlanePointWithVector(
        final String id,
        final PlanePoint point,
        final PreciseDecimal direction,
        final PreciseDecimal speed
    ) {
        this.id = id;
        this.point = point;
        this.direction = direction;
        this.speed = speed;
    }

    @Override
    public final String toString() {
        return "{ " +
            "id: " + this.id + ", " +
            "point: " + this.point.toString() +
            "vector:" + "(" + this.direction + ", " + this.speed + ")" +
        " }";
    }
    
    public static final PlanePointWithVector from(
        final String id,
        final PlanePoint point,
        final PreciseDecimal direction,
        final PreciseDecimal speed
    ) {
        return new PlanePointWithVector(
            id,
            point,
            direction,
            speed
        );
    }

    public static final PlanePointWithVector from(
        final String id,
        final PlanePoint planeType,
        final int direction,
        final int speed
    ) {
        return new PlanePointWithVector(
            id,
            planeType,
            PreciseDecimal.from(direction),
            PreciseDecimal.from(speed)
        );
    }
}
