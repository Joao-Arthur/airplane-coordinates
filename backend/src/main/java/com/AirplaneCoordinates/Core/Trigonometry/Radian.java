package com.AirplaneCoordinates.Core.Trigonometry;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimalOperations;

public final class Radian {
    public final PreciseDecimal value; 

    private Radian(final PreciseDecimal value) {
        this.value = value;
    }

    public static Radian from(final PreciseDecimal value) {
        return new Radian(value);
    }

    public final Degree toDeg() {
        final var halfCircle = PreciseDecimal.from(180);
        final var pi = PreciseDecimal.pi();

        final var val1 = PreciseDecimalOperations.mul(this.value, halfCircle);
        final var val2 = PreciseDecimalOperations.div(val1, pi);

        return Degree.from(val2);
    }   
}
