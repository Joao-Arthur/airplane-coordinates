package com.AirplaneCoordinates.Features.PointsCloseToEachOther;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public final class PointCloseToEachOtherDTOTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            PointCloseToEachOtherDTO.from("3", "5", "-17.86").toString(),
            "{ a: 3, b: 5, distanceFromPoint: -17.86 }"
        );
    }
}
