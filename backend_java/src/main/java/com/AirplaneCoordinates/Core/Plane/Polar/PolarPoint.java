package com.AirplaneCoordinates.Core.Plane.Polar;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimalOperations;
import com.AirplaneCoordinates.Core.Trigonometry.Trigonometry;

public final class PolarPoint {
    public final PreciseDecimal r;
    public final PreciseDecimal a;
    public final String value;

    public PolarPoint(
        final PreciseDecimal r,
        final PreciseDecimal a
    ) {
        this.r = r;
        this.a = a;
        this.value = "(" + r.value + ", " + a.value + ")";
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
        final var angleSum = PreciseDecimalOperations.sum(this.a, angle);
        final var normalizedAngle = Trigonometry.normalizeAngle(angleSum);

        return new PolarPoint(
            this.r,
            normalizedAngle
        );
    }
}
