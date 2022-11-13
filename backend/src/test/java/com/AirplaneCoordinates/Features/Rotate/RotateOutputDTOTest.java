package com.AirplaneCoordinates.Features.Rotate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public class RotateOutputDTOTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            new RotateOutputDTO(
                PlanePoint.from(Plane.CARTESIAN, 7, 86)
            ).toString(),
            "{ point: (CARTESIAN, 7, 86) }"
        );
    }
}
