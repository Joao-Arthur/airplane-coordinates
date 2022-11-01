package com.AirplaneCoordinates.Core.Plane.Polar;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimalOperations;
import com.AirplaneCoordinates.Core.Trigonometry.Degree;

public final class PolarPoint {
    public final PreciseDecimal r;
    public final PreciseDecimal a;

    private PolarPoint(
        final PreciseDecimal r,
        final PreciseDecimal a
    ) {
        this.r = r;
        this.a = a;
    }

    @Override
    public final String toString() {
        return "(" + this.r.value + ", " + this.a.value + ")";
    }

    public static final PolarPoint from(final int r, final int a) {
        return new PolarPoint(
            PreciseDecimal.from(r),
            PreciseDecimal.from(a)
        );
    }

    public static final PolarPoint from(final int r, final String a) {
        return new PolarPoint(
            PreciseDecimal.from(r),
            PreciseDecimal.from(a)
        );
    }

    public static final PolarPoint from(final String r, final String a) {
        return new PolarPoint(
            PreciseDecimal.from(r),
            PreciseDecimal.from(a)
        );
    }

    public static final PolarPoint from(
        final PreciseDecimal r,
        final PreciseDecimal a
    ) {
        return new PolarPoint(
            r,
            a
        );
    }

    public final CartesianPoint toCartesian() {
        final var radianValue = Degree.from(this.a).toRad().value;
        final var x = PreciseDecimalOperations.mul(
            this.r,
            radianValue.cos()
        );
        final var y = PreciseDecimalOperations.mul(
            this.r,
            radianValue.sin()
        );

        return CartesianPoint.from(x, y);
    }

    public final PolarPoint rotate(final PreciseDecimal angle) {
        final var angleSum = PreciseDecimalOperations.sum(this.a, angle);
        final var normalizedAngle = Degree.from(angleSum).normalized();

        return new PolarPoint(
            this.r,
            normalizedAngle
        );
    }

    public final PolarPoint round() {
        return new PolarPoint(
            this.r.round(),
            Degree.from(this.a.round()).normalized()
        );
    }
}
