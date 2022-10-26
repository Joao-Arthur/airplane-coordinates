package com.AirplaneCoordinates.Core.Plane.Conversion;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Polar.PolarPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimalOperations;
import com.AirplaneCoordinates.Core.Trigonometry.Trigonometry;

public final class PlaneConversion {
    public static final PolarPoint cartesianToPolar(final CartesianPoint point) {
        final var r = PreciseDecimalOperations.sum(point.x.square(), point.y.square()).sqrt();
        final var a = Trigonometry.normalizeAngle(Trigonometry.radToDeg(point.y));//atan

        return new PolarPoint(r, a);
    }

    public static final CartesianPoint polarToCartesian(final PolarPoint point) {
        final var x = PreciseDecimalOperations.mul(point.r, Trigonometry.degToRad(Trigonometry.normalizeAngle(point.a)));//cos()
        final var y = PreciseDecimalOperations.mul(point.r, Trigonometry.degToRad(Trigonometry.normalizeAngle(point.a)));//sin()

        return new CartesianPoint(x, y);
    }
}