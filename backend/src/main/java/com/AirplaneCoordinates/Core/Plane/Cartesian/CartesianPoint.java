package com.AirplaneCoordinates.Core.Plane.Cartesian;

import com.AirplaneCoordinates.Core.Mathematics.Arithmetic;
import com.AirplaneCoordinates.Core.Plane.Polar.PolarPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.Trigonometry.Rad;

public final class CartesianPoint implements
    Arithmetic<CartesianPoint>
{
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
        final var xSquare = this.x.square();
        final var ySquare = this.y.square();
        final var val1 = xSquare.plus(ySquare);
        final var r = val1.sqrt();

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

    public final CartesianPoint plus(final CartesianPoint other) {
        return CartesianPoint.from(
            this.x.plus(other.x),
            this.y.plus(other.y)
        );
    }

    public final CartesianPoint minus(final CartesianPoint other) {
        return CartesianPoint.from(
            this.x.minus(other.x),
            this.y.minus(other.y)
        );
    }

    public final CartesianPoint times(final CartesianPoint other) {
        return CartesianPoint.from(
           this.x.times(other.x),
           this.y.times(other.y) 
        );
    }

    public final CartesianPoint divide(final CartesianPoint other) {
        return CartesianPoint.from(
           this.x.divide(other.x),
           this.y.divide(other.y) 
        );
    }

    public final CartesianPoint remainder(final CartesianPoint other) {
        return CartesianPoint.from(
           this.x.remainder(other.x),
           this.y.remainder(other.y) 
        );
    }

    public static final PreciseDecimal distance(final CartesianPoint a, final CartesianPoint b) {
        final var delta = a.minus(b);
        
        final var xSquare = delta.x.square();
        final var ySquare = delta.y.square();

        final var val1 = xSquare.plus(ySquare);
        final var val2 = val1.sqrt();
        
        return val2;
    }
}
