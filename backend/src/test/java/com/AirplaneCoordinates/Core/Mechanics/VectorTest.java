package com.AirplaneCoordinates.Core.Mechanics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public final class VectorTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            Vector.from("-42.1", "+2.202").toString(),
            "(-42.1º, +2.202km/h)"
        );
    }
}
