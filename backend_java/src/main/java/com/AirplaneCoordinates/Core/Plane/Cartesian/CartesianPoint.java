package com.AirplaneCoordinates.Core.Plane.Cartesian;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class CartesianPoint {
    public final PreciseDecimal x;
    public final PreciseDecimal y;
    public final String value;

    private CartesianPoint(
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

    public static final CartesianPoint from(final PreciseDecimal x, final PreciseDecimal y) {
        return new CartesianPoint(
            x,
            y
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

    public final CartesianPoint round() {
        return new CartesianPoint(
            this.x.round(),
            this.y.round()
        );
    }
}
