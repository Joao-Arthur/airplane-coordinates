package com.AirplaneCoordinates.Core.Plane.Polar;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimalOperations;

public final class PolarPoint {
    public final PreciseDecimal r;
    public final PreciseDecimal a;

    public PolarPoint(
        final PreciseDecimal r,
        final PreciseDecimal a
    ) {
        this.r = r;
        this.a = a;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (!(object instanceof PolarPoint))
            return false;
        PolarPoint other = (PolarPoint) object;
        return this.r.equals(other.r) && this.a.equals(other.a);
    }

    public static final PolarPoint from(final int r, final int a) {
        return new PolarPoint(
            PreciseDecimal.from(r),
            PreciseDecimal.from(a)
        );
    }

    public static final PolarPoint from(final int r, final String a) {
        return new PolarPoint(
            PreciseDecimal.from(r),
            PreciseDecimal.from(a)
        );
    }

    public final PolarPoint rotate(final PreciseDecimal angle) {
        return new PolarPoint(
            this.r,
            PreciseDecimalOperations.sum(this.a, angle)
        );
    }
}
