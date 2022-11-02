package com.AirplaneCoordinates.Core.LinearFunction;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimalOperations;
import com.AirplaneCoordinates.Core.Trigonometry.Degree;

public final class LinearFunction {
    private final PreciseDecimal a;
    private final PreciseDecimal b;
    
    private LinearFunction(
        final PreciseDecimal a,
        final PreciseDecimal b
    ) {
        this.a = a;
        this.b = b;
    }

    @Override
    public final String toString() {
        return "y = " + this.a.format() + "x " + this.b.format();
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
}
