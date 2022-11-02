package com.AirplaneCoordinates.Core.Mechanics;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class PlaneVectorTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            new PlaneVector(
                PlanePoint.from(Plane.CARTESIAN, "-7", "9.1"),
                Vector.from("-42.1", "+2.202")
            ).toString(),
            "{ point: (CARTESIAN, -7, 9.1), vector: (-42.1º, +2.202km/h) }"
        );
    }
}
