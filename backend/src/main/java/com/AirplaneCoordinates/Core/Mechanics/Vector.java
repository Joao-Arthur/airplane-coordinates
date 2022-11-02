package com.AirplaneCoordinates.Core.Mechanics;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class Vector {
    public final PreciseDecimal direction;
    public final PreciseDecimal speed;

    private Vector(
        final PreciseDecimal direction,
        final PreciseDecimal speed
    ) {
        this.direction = direction;
        this.speed = speed;
    }

    @Override
    public final String toString() {
        return  "(" + this.direction + "º, " + this.speed + "km/h)";
    }

    public static final Vector from(
        final PreciseDecimal direction,
        final PreciseDecimal speed
    ) {
        return new Vector(direction, speed);
    }

    public static final Vector from(
        final int direction,
        final int speed
    ) {
        return new Vector(
            PreciseDecimal.from(direction),
            PreciseDecimal.from(speed)
        );
    }

    public static final Vector from(
        final String direction,
        final String speed
    ) {
        return new Vector(
            PreciseDecimal.from(direction),
            PreciseDecimal.from(speed)
        );
    }
}
