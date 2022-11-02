 package com.AirplaneCoordinates.Features.PointsCloseToPoint;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public final class PointCloseToPointDTOTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            PointCloseToPointDTO.from("4", "4.2768").toString(),
            "{ id: 4, distanceFromPoint: 4.2768 }"
        );
    }
}
