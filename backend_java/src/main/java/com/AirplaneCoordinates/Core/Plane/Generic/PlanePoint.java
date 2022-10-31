package com.AirplaneCoordinates.Core.Plane.Generic;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Conversion.PlaneConversion;
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

    @Override
    public final String toString() {
        return "(" + planeType + ", " + a.value + ", " + b.value + ")";
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

    public static final PlanePoint from(final Plane plane, final PreciseDecimal a, final PreciseDecimal b) {
        return new PlanePoint(
            plane,
            a,
            b
        );
    }

    public static final PlanePoint from(final Plane plane, final int a, final int b) {
        return new PlanePoint(
            plane,
            PreciseDecimal.from(a),
            PreciseDecimal.from(b)
        );
    }

    public static final PlanePoint from(final Plane plane, final String a, final String b) {
        return new PlanePoint(
            plane,
            PreciseDecimal.from(a),
            PreciseDecimal.from(b)
        );
    }

    public final CartesianPoint toCartesian() {
        switch (this.planeType) {
            case CARTESIAN:
                return CartesianPoint.from(a, b);
            case POLAR:
                return PlaneConversion.polarToCartesian(
                    PolarPoint.from(a, b)
                );
            default:
                throw new RuntimeException("planeType is required");
        }
    }

    public final PolarPoint toPolar() {
        switch (this.planeType) {
            case CARTESIAN:
                return PlaneConversion.cartesianToPolar(
                    CartesianPoint.from(a, b)
                );
            case POLAR:
                return PolarPoint.from(a, b);
            default:
                throw new RuntimeException("planeType is required");
        }
    }
}
