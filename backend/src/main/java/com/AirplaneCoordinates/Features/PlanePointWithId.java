package com.AirplaneCoordinates.Features;

import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PlanePointWithId {
    public final String id;
    public final Plane planeType;
    public final PreciseDecimal a;
    public final PreciseDecimal b;

    private PlanePointWithId(
        final String id,
        final Plane planeType,
        final PreciseDecimal a,
        final PreciseDecimal b
    ) {
        this.id = id;
        this.planeType = planeType;
        this.a = a;
        this.b = b;
    }

    @Override
    public final String toString() {
        return "{ " +
            "id: " + id + ", " +
            "planeType: " + planeType + ", " +
            "a: " + a.value + ", " +
            "b: " + b.value +
        " }";
    }

    public final PlanePoint getPoint() {
        return PlanePoint.from(
            this.planeType,
            this.a,
            this.b
        );
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
