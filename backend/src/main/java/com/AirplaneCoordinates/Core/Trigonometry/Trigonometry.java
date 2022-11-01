package com.AirplaneCoordinates.Core.Trigonometry;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimalOperations;

public final class Trigonometry {
    public static final PreciseDecimal radToDeg(final PreciseDecimal rad) {
        final var halfCircle = PreciseDecimal.from(180);
        final var pi = PreciseDecimal.pi();

        final var val1 = PreciseDecimalOperations.mul(rad, halfCircle);
        final var val2 = PreciseDecimalOperations.div(val1, pi);

        return val2;
    }   

    public static final PreciseDecimal degToRad(final PreciseDecimal deg) {
        final var halfCircle = PreciseDecimal.from(180);
        final var pi = PreciseDecimal.pi();

        final var val1 = PreciseDecimalOperations.mul(deg, pi);
        final var val2 = PreciseDecimalOperations.div(val1, halfCircle);

        return val2;
    }

    public static final PreciseDecimal normalizeAngle(final PreciseDecimal deg) {
        final var fullCircle = PreciseDecimal.from(360);

        final var val1 = PreciseDecimalOperations.rem(deg, fullCircle);
        final var val2 = PreciseDecimalOperations.sum(val1, fullCircle);
        final var val3 = PreciseDecimalOperations.rem(val2, fullCircle);

        return val3;
    }

    public static final boolean isInfiniteTangentAngle(final PreciseDecimal deg) {
        return (
            PreciseDecimal.from(90).equals(deg) ||
            PreciseDecimal.from(270).equals(deg)
        );
    }
}
