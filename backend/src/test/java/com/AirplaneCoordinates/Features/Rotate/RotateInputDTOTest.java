package com.AirplaneCoordinates.Features.Rotate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class RotateInputDTOTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            new RotateInputDTO(
                PlanePoint.from(Plane.POLAR, 4, 90),
                CartesianPoint.from(4, 4),
                PreciseDecimal.from(90)
            ).toString(),
            "{ point: (POLAR, 4, 90), centerOfRotation: (4, 4), angle: 90 }"
        );
    }
}
