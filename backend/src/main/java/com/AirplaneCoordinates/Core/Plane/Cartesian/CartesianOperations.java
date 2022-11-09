package com.AirplaneCoordinates.Core.Plane.Cartesian;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class CartesianOperations {
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
        final var delta = CartesianOperations.sub(a, b);
        
        return PreciseDecimal.sum(delta.x.square(), delta.y.square()).sqrt();
    }
}
