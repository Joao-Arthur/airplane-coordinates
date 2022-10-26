package com.AirplaneCoordinates.Core.Plane.Cartesian;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class CartesianPoint {
    public final PreciseDecimal x;
    public final PreciseDecimal y;

    public CartesianPoint(
        final PreciseDecimal x,
        final PreciseDecimal y
    ) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof CartesianPoint))
            return false;
        CartesianPoint other = (CartesianPoint)object;
        return this.x.equals(other.x) && this.y.equals(other.y);
    }

    public static final CartesianPoint from(final int x, final int y) {
        return new CartesianPoint(
            PreciseDecimal.from(x),
            PreciseDecimal.from(y)
        );
    }
}
