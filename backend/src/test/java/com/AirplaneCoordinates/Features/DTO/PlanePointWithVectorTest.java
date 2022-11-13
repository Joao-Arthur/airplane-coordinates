package com.AirplaneCoordinates.Features.DTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Mechanics.Vector;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class PlanePointWithVectorTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            new PlanePointWithVector(
                "5",
                PlanePoint.from(Plane.CARTESIAN, "-3", "2.41"),
                Vector.from(135, 3)
            ).toString(),
            "{ id: 5, point: (CARTESIAN, -3, 2.41), vector: (135º, 3km/h) }"
        );
    }
}
