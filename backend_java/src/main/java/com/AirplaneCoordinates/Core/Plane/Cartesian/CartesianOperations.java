package com.AirplaneCoordinates.Core.Plane.Cartesian;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimalArithmeticOperations;

public final class CartesianOperations {
    public static final CartesianPoint sum(final CartesianPoint a, final CartesianPoint b) {
        return new CartesianPoint(
            PreciseDecimalArithmeticOperations.sum(a.x, b.x),
            PreciseDecimalArithmeticOperations.sum(a.y, b.y)
        );
    }
    public static final CartesianPoint sub(final CartesianPoint a, final CartesianPoint b) {
        return new CartesianPoint(
            PreciseDecimalArithmeticOperations.sub(a.x, b.x),
            PreciseDecimalArithmeticOperations.sub(a.y, b.y)
        );
    }
    public static final CartesianPoint mul(final CartesianPoint a, final CartesianPoint b) {
        return new CartesianPoint(
           PreciseDecimalArithmeticOperations.mul(a.x, b.x),
           PreciseDecimalArithmeticOperations.mul(a.y, b.y) 
        );
    }
    public static final CartesianPoint div(final CartesianPoint a, final CartesianPoint b) {
        return new CartesianPoint(
           PreciseDecimalArithmeticOperations.div(a.x, b.x),
           PreciseDecimalArithmeticOperations.div(a.y, b.y) 
        );
    }
}
