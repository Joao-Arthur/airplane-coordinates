package com.AirplaneCoordinates.Core.Plane.Cartesian;

import com.AirplaneCoordinates.Core.Plane.Polar.PolarPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.Trigonometry.Rad;

public final class CartesianPoint {
    public final PreciseDecimal x;
    public final PreciseDecimal y;

    private CartesianPoint(
        final PreciseDecimal x,
        final PreciseDecimal y
    ) {
        this.x = x;
        this.y = y;
    }

    @Override
    public final String toString() {
        return "(" + this.x.value + ", " + this.y.value + ")";
    }

    public static final CartesianPoint from(final int x, final int y) {
        return new CartesianPoint(
            PreciseDecimal.from(x),
            PreciseDecimal.from(y)
        );
    }

    public static final CartesianPoint from(final String x, final String y) {
        return new CartesianPoint(
            PreciseDecimal.from(x),
            PreciseDecimal.from(y)
        );
    }

    public static final CartesianPoint from(
        final PreciseDecimal x,
        final PreciseDecimal y
    ) {
        return new CartesianPoint(
            x,
            y
        );
    }

    public final PolarPoint toPolar() {
        final var r = PreciseDecimal.sum(
            this.x.square(),
            this.y.square()
        ).sqrt();
        final var a = Rad
            .from(PreciseDecimal.atan(this.y, this.x))
            .toDeg()
            .normalized();

        return PolarPoint.from(r, a);
    }

    public final CartesianPoint opposite() {
        return new CartesianPoint(
            this.x.opposite(),
            this.y.opposite()
        );
    }

    public final CartesianPoint reverse() {
        return new CartesianPoint(
            this.x.reverse(),
            this.y.reverse()
        );
    }

    public final CartesianPoint round() {
        return new CartesianPoint(
            this.x.round(),
            this.y.round()
        );
    }

    public static final CartesianPoint sum(final CartesianPoint a, final CartesianPoint b) {
        return CartesianPoint.from(
            PreciseDecimal.sum(a.x, b.x),
            PreciseDecimal.sum(a.y, b.y)
        );
    }

    public static final CartesianPoint sub(final CartesianPoint a, final CartesianPoint b) {
        return CartesianPoint.from(
            PreciseDecimal.sub(a.x, b.x),
            PreciseDecimal.sub(a.y, b.y)
        );
    }

    public static final CartesianPoint mul(final CartesianPoint a, final CartesianPoint b) {
        return CartesianPoint.from(
           PreciseDecimal.mul(a.x, b.x),
           PreciseDecimal.mul(a.y, b.y) 
        );
    }

    public static final CartesianPoint div(final CartesianPoint a, final CartesianPoint b) {
        return CartesianPoint.from(
           PreciseDecimal.div(a.x, b.x),
           PreciseDecimal.div(a.y, b.y) 
        );
    }

    public static final PreciseDecimal distance(final CartesianPoint a, final CartesianPoint b) {
        final var delta = CartesianPoint.sub(a, b);
        
        return PreciseDecimal.sum(delta.x.square(), delta.y.square()).sqrt();
    }
}
