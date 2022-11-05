package com.AirplaneCoordinates.Core.LinearFunction;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimalOperations;
import com.AirplaneCoordinates.Core.Trigonometry.Degree;

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
            this.a.format() + "x " +
            (this.b.equals(PreciseDecimal.from(0)) ? "+0" : this.b.format());
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
        final var angularCoefficient = Degree.from(angle).toRad().value.tan();
        final var expected = PreciseDecimalOperations.mul(angularCoefficient, point.x);
        final var linearCoefficient = PreciseDecimalOperations.sub(point.y, expected);
    
        return new LinearFunction(
            angularCoefficient,
            linearCoefficient
        );
    }

    public final PreciseDecimal root() {
        return PreciseDecimalOperations.div(this.b.opposite(), this.a);
    }

    public final PreciseDecimal execute(final PreciseDecimal x) {
        final var val1 = PreciseDecimalOperations.mul(this.a, x);
        final var val2 = PreciseDecimalOperations.sum(val1, this.b);

        return val2;
    }

    public static final LinearFunction intersect(
        final LinearFunction fx,
        final LinearFunction gx
    ) {
        return LinearFunction.from(
            PreciseDecimalOperations.sub(fx.a, gx.a),
            PreciseDecimalOperations.sub(fx.b, gx.b)
        );
    }

    public static final CartesianPoint intersectionPoint(
        final LinearFunction fx,
        final LinearFunction gx
    ) {
        final var intersectedFn = LinearFunction.intersect(fx, gx );
        final var root = intersectedFn.root();
        final var fy = fx.execute(root);

        return CartesianPoint.from(root, fy);
    }
}
