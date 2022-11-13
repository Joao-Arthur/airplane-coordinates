 package com.AirplaneCoordinates.Features.PointsCloseToPoint;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PointsCloseToPointOutputDTOTest {
    @Test
    public final void toStringTest() {
        final var points = new ArrayList<PointCloseToPointOutputDTO>();
        points.add(new PointCloseToPointOutputDTO("1", PreciseDecimal.from("1.11")));
        points.add(new PointCloseToPointOutputDTO("2", PreciseDecimal.from("2.34")));
        points.add(new PointCloseToPointOutputDTO("3", PreciseDecimal.from("4.57")));
        points.add(new PointCloseToPointOutputDTO("4", PreciseDecimal.from("6.22")));

        final var dto = new PointsCloseToPointOutputDTO(points);

        assertEquals(
            dto.toString(),
            "{\n" +
            "    points: [\n" +
            "        { id: 1, distanceFromPoint: 1.11 },\n" +
            "        { id: 2, distanceFromPoint: 2.34 },\n" +
            "        { id: 3, distanceFromPoint: 4.57 },\n" +
            "        { id: 4, distanceFromPoint: 6.22 },\n" +
            "    ]\n" +
            "}"
        );
    }
}
