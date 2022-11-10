package com.AirplaneCoordinates.Core.Mechanics;

import com.AirplaneCoordinates.Core.LinearFunction.LinearFunction;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class LinearPoint {
    public final PreciseDecimal initialPoint;
    public final PreciseDecimal speed;

    private LinearPoint(
        final PreciseDecimal initialPoint,
        final PreciseDecimal speed
    ) {
        this.initialPoint = initialPoint;
        this.speed = speed;
    }

    @Override
    public final String toString() {
        return  "(" + this.initialPoint + "km, " + this.speed + "km/h)";
    }

    public static final LinearPoint from(
        final PreciseDecimal initialPoint,
        final PreciseDecimal speed
    ) {
        return new LinearPoint(initialPoint, speed);
    }

    public static final LinearPoint from(
        final int initialPoint,
        final int speed
    ) {
        return new LinearPoint(
            PreciseDecimal.from(initialPoint),
            PreciseDecimal.from(speed)
        );
    }

    public static final LinearPoint from(
        final String initialPoint,
        final String speed
    ) {
        return new LinearPoint(
            PreciseDecimal.from(initialPoint),
            PreciseDecimal.from(speed)
        );
    }

    public static final CartesianPoint collisionPoint(
        final LinearPoint a,
        final LinearPoint b
    ) {
        return LinearFunction.intersectionPoint(
            LinearFunction.from(a.speed, a.initialPoint),
            LinearFunction.from(b.speed, b.initialPoint)
        );
    }

    public final PreciseDecimal timeTo(final PreciseDecimal point) {
        final var val1 = point.minus(this.initialPoint);
        final var val2 = val1.divide(this.speed);

        return val2;
    }
}
