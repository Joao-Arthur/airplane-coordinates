package com.AirplaneCoordinates.Features.Translate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class TranslateOutputDTOTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            new TranslateOutputDTO(
                PlanePoint.from(Plane.POLAR, 1, 0)
            ).toString(),
            "{ point: (POLAR, 1, 0) }"
        );
    }
}
