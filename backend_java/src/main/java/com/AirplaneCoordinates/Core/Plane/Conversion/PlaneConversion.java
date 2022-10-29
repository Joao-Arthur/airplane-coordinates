package com.AirplaneCoordinates.Core.Plane.Conversion;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Polar.PolarPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimalOperations;
import com.AirplaneCoordinates.Core.Trigonometry.Trigonometry;

public final class PlaneConversion {
    public static final PolarPoint cartesianToPolar(final CartesianPoint point) {
        final var r = PreciseDecimalOperations.sum(
            point.x.square(),
            point.y.square()
        ).sqrt();
        final var a = Trigonometry.normalizeAngle(
            Trigonometry.radToDeg(
                PreciseDecimalOperations.atan(point.y, point.x)
            )
        );

        return new PolarPoint(r, a);
    }

    public static final CartesianPoint polarToCartesian(final PolarPoint point) {
        final var radianValue = Trigonometry.degToRad(Trigonometry.normalizeAngle(point.a));
        final var x = PreciseDecimalOperations.mul(
            point.r,
            radianValue.cos()
        );
        final var y = PreciseDecimalOperations.mul(
            point.r,
            radianValue.sin()
        );

        return new CartesianPoint(x, y);
    }
}
