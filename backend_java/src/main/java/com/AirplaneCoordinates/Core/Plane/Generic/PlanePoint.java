package com.AirplaneCoordinates.Core.Plane.Generic;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Polar.PolarPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PlanePoint {
    public final Plane planeType;
    public final PreciseDecimal a;
    public final PreciseDecimal b;

    private PlanePoint(
        final Plane planeType,
        final PreciseDecimal a,
        final PreciseDecimal b
    ) {
        this.planeType = planeType;
        this.a = a;
        this.b = b;
    }

    public static final PlanePoint fromCartesian(final CartesianPoint point) {
        return new PlanePoint(
            Plane.CARTESIAN,
            point.x,
            point.y
        );
    }

    public static final PlanePoint fromPolar(final PolarPoint point) {
        return new PlanePoint(
            Plane.POLAR,
            point.r,
            point.a
        );
    }
}
