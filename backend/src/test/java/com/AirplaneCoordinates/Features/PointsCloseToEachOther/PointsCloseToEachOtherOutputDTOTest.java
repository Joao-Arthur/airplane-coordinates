 package com.AirplaneCoordinates.Features.PointsCloseToEachOther;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PointsCloseToEachOtherOutputDTOTest {
    @Test
    public final void toStringTest() {
        final var points = new ArrayList<PointCloseToEachOtherOutputDTO>();
        points.add(new PointCloseToEachOtherOutputDTO("1", "2", PreciseDecimal.from("1.11")));
        points.add(new PointCloseToEachOtherOutputDTO("2", "3", PreciseDecimal.from("2.34")));
        points.add(new PointCloseToEachOtherOutputDTO("3", "4", PreciseDecimal.from("4.57")));
        points.add(new PointCloseToEachOtherOutputDTO("4", "5", PreciseDecimal.from("6.22")));

        final var dto = new PointsCloseToEachOtherOutputDTO(points);

        assertEquals(
            dto.toString(),
            "{\n" +
            "    points: [\n" +
            "        { a: 1, b: 2, distance: 1.11 },\n" +
            "        { a: 2, b: 3, distance: 2.34 },\n" +
            "        { a: 3, b: 4, distance: 4.57 },\n" +
            "        { a: 4, b: 5, distance: 6.22 },\n" +
            "    ]\n" +
            "}"
        );
    }
}
