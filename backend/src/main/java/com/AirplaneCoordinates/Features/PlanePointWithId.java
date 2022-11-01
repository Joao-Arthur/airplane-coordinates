package com.AirplaneCoordinates.Features;

import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PlanePointWithId {
    public final String id;
    public final PlanePoint point;

    private PlanePointWithId(
        final String id,
        final Plane planeType,
        final PreciseDecimal a,
        final PreciseDecimal b
    ) {
        this.id = id;
        this.point = PlanePoint.from(
            planeType,
            a,
            b
        );
    }

    @Override
    public final String toString() {
        return "{ " +
            "id: " + this.id + ", " +
            "point: " + this.point.toString() +
        " }";
    }

    public final PlanePoint getPoint() {
        return this.point;
    }
    
    public static final PlanePointWithId from(
        final String id,
        final Plane planeType,
        final PreciseDecimal a,
        final PreciseDecimal b
    ) {
        return new PlanePointWithId(
            id,
            planeType,
            a,
            b
        );
    }

    public static final PlanePointWithId from(
        final String id,
        final Plane planeType,
        final int a,
        final int b
    ) {
        return new PlanePointWithId(
            id,
            planeType,
            PreciseDecimal.from(a),
            PreciseDecimal.from(b)
        );
    }
}
