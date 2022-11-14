package com.AirplaneCoordinates.Plain.Core.Mechanics;

import com.AirplaneCoordinates.Core.Mechanics.Vector;

public final class VectorPlain {
    public final String direction;
    public final String speed;

    public VectorPlain(
        final String direction,
        final String speed
    ) {
        this.direction = direction;
        this.speed = speed;
    }

    public final Vector toObject() {
        return Vector.from(direction, speed);
    }
}
