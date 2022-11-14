package com.AirplaneCoordinates.Features.DTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class PlanePointWithIdTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            new PlanePointWithId(
                "5",
                PlanePoint.from(Plane.CARTESIAN, "-3", "2.41")
            ).toString(),
            "{ id: 5, point: (CARTESIAN, -3, 2.41) }"
        );
    }
}
