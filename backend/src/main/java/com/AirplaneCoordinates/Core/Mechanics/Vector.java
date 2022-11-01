package com.AirplaneCoordinates.Core.Mechanics;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class Vector {
    public final PreciseDecimal direction;
    public final PreciseDecimal speed;

    public Vector (
        final PreciseDecimal direction,
        final PreciseDecimal speed
    ) {
        this.direction = direction;
        this.speed = speed;
    }

    @Override
    public final String toString() {
        return  "(" + this.direction + ", " + this.speed + ")";
    }
}
