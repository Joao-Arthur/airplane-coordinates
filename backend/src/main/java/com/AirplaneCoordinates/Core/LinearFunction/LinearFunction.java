package com.AirplaneCoordinates.Core.LinearFunction;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.Trigonometry.Deg;

public final class LinearFunction {
    public final PreciseDecimal a;
    public final PreciseDecimal b;
    
    private LinearFunction(
        final PreciseDecimal a,
        final PreciseDecimal b
    ) {
        this.a = a;
        this.b = b;
    }

    @Override
    public final String toString() {
        return "y = " +
            this.a.format() + "x" +
            (
                this.b.equals(PreciseDecimal.from(0))
                ? "+0"
                : this.b.format()
            );
    }

    public static final LinearFunction from(
        final PreciseDecimal a,
        final PreciseDecimal b
    ) {
        return new LinearFunction(a, b);
    }

    public static final LinearFunction from(
        final int a,
        final int b
    ) {
        return new LinearFunction(
            PreciseDecimal.from(a),
            PreciseDecimal.from(b)
        );
    }

    public static final LinearFunction from(
        final String a,
        final String b
    ) {
        return new LinearFunction(
            PreciseDecimal.from(a),
            PreciseDecimal.from(b)
        );
    }

    public static final LinearFunction from(
        final CartesianPoint point,
        final PreciseDecimal angle
    ) {
        final var angularCoefficient = Deg.from(angle).toRad().value.tan();
        final var expected = angularCoefficient.times(point.x);
        final var linearCoefficient = point.y.minus(expected);

        return new LinearFunction(
            angularCoefficient.round(),
            linearCoefficient.round()
        );
    }

    public final PreciseDecimal root() {
        // Does not cover a = 0, b <> 0
        if (this.b.equals(PreciseDecimal.from(0)))
            return PreciseDecimal.from(0);
        return this.b.opposite().divide(this.a);
    }

    public final PreciseDecimal execute(final PreciseDecimal x) {
        final var val1 = this.a.times(x);
        final var val2 = val1.plus(this.b);

        return val2;
    }

    public static final LinearFunction intersect(
        final LinearFunction fx,
        final LinearFunction gx
    ) {
        return LinearFunction.from(
            fx.a.minus(gx.a),
            fx.b.minus(gx.b)
        );
    }

    public static final CartesianPoint intersectionPoint(
        final LinearFunction fx,
        final LinearFunction gx
    ) {
        final var intersectedFn = LinearFunction.intersect(fx, gx);
        final var root = intersectedFn.root();
        final var fy = fx.execute(root);

        return CartesianPoint.from(root, fy);
    }
}
