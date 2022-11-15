 package com.AirplaneCoordinates.Features.PointsCloseToEachOther;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.List.CustomArrayList;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class PointsCloseToEachOtherInputDTOTest {
    @Test
    public final void toStringTest() {
        final var dto = new PointsCloseToEachOtherInputDTO(
            new CustomArrayList<PlanePointWithId>()
                .insert(new PlanePointWithId("1", PlanePoint.from(Plane.CARTESIAN, 10, 10)))
                .insert(new PlanePointWithId("2", PlanePoint.from(Plane.CARTESIAN, 10, 20)))
                .insert(new PlanePointWithId("3", PlanePoint.from(Plane.CARTESIAN, 0, 20)))
                .insert(new PlanePointWithId("4", PlanePoint.from(Plane.CARTESIAN, 2, 22))),
            PreciseDecimal.from(10)
        );

        assertEquals(
            dto.toString(),
            "{\n" +
            "    points: [\n" +
            "        { id: 1, point: (CARTESIAN, 10, 10) },\n" +
            "        { id: 2, point: (CARTESIAN, 10, 20) },\n" +
            "        { id: 3, point: (CARTESIAN, 0, 20) },\n" +
            "        { id: 4, point: (CARTESIAN, 2, 22) },\n" +
            "    ],\n" +
            "    maxDistance: 10\n" +
            "}"
        );
    }
}
