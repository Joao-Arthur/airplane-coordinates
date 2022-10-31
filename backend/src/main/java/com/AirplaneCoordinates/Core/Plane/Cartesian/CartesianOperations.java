package com.AirplaneCoordinates.Core.Plane.Cartesian;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimalOperations;

public final class CartesianOperations {
    public static final CartesianPoint sum(final CartesianPoint a, final CartesianPoint b) {
        return CartesianPoint.from(
            PreciseDecimalOperations.sum(a.x, b.x),
            PreciseDecimalOperations.sum(a.y, b.y)
        );
    }

    public static final CartesianPoint sub(final CartesianPoint a, final CartesianPoint b) {
        return CartesianPoint.from(
            PreciseDecimalOperations.sub(a.x, b.x),
            PreciseDecimalOperations.sub(a.y, b.y)
        );
    }

    public static final CartesianPoint mul(final CartesianPoint a, final CartesianPoint b) {
        return CartesianPoint.from(
           PreciseDecimalOperations.mul(a.x, b.x),
           PreciseDecimalOperations.mul(a.y, b.y) 
        );
    }

    public static final CartesianPoint div(final CartesianPoint a, final CartesianPoint b) {
        return CartesianPoint.from(
           PreciseDecimalOperations.div(a.x, b.x),
           PreciseDecimalOperations.div(a.y, b.y) 
        );
    }

    public static final PreciseDecimal distance(final CartesianPoint a, final CartesianPoint b) {
        final var delta = CartesianOperations.sub(a, b);
        
        return PreciseDecimalOperations.sum(delta.x.square(), delta.y.square()).sqrt();
    }
}
