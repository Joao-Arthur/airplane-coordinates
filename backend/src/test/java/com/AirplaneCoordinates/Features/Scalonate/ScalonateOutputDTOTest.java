package com.AirplaneCoordinates.Features.Scalonate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class ScalonateOutputDTOTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            new ScalonateOutputDTO(
                PlanePoint.from(Plane.POLAR, 7, 86)
            ).toString(),
            "{ point: (POLAR, 7, 86) }"
        );
    }
}
