package com.AirplaneCoordinates.Core.Plane.Cartesian;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class CartesianPoint {
    public final PreciseDecimal x;
    public final PreciseDecimal y;
    public final String value;

    public CartesianPoint(
        final PreciseDecimal x,
        final PreciseDecimal y
    ) {
        this.x = x;
        this.y = y;
        this.value = "(" + x.value + ", " + y.value + ")";
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
}
