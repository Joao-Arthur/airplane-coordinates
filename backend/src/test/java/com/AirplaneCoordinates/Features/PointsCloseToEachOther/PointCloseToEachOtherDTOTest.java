package com.AirplaneCoordinates.Features.PointsCloseToEachOther;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PointCloseToEachOtherDTOTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            new PointCloseToEachOtherOutputDTO("3", "5", PreciseDecimal.from("-17.86")).toString(),
            "{ a: 3, b: 5, distanceFromPoint: -17.86 }"
        );
    }
}
