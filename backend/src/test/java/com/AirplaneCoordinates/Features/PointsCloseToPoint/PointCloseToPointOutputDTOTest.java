 package com.AirplaneCoordinates.Features.PointsCloseToPoint;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PointCloseToPointOutputDTOTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            new PointsCloseToPointOutputDTO("4", PreciseDecimal.from("4.2768")).toString(),
            "{ id: 4, distanceFromPoint: 4.2768 }"
        );
    }
}
