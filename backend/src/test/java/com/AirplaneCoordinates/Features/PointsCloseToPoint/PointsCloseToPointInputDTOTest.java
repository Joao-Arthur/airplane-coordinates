 package com.AirplaneCoordinates.Features.PointsCloseToPoint;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class PointsCloseToPointInputDTOTest {
    @Test
    public final void toStringTest() {
        final var points = new ArrayList<PlanePointWithId>();
        points.add(new PlanePointWithId("1", PlanePoint.from(Plane.CARTESIAN, 0, 8)));
        points.add(new PlanePointWithId("2", PlanePoint.from(Plane.CARTESIAN, 10, 0)));
        points.add(new PlanePointWithId("3", PlanePoint.from(Plane.CARTESIAN, -2, -2)));
        points.add(new PlanePointWithId("4", PlanePoint.from(Plane.CARTESIAN, 10, 10)));

        final var dto = new PointsCloseToPointInputDTO(
            points,
            CartesianPoint.from(5, 7),
            PreciseDecimal.from(10)
        );

        assertEquals(
            dto.toString(),
            "{\n" +
            "    points: [\n" +
            "        { id: 1, point: (CARTESIAN, 0, 8) },\n" +
            "        { id: 2, point: (CARTESIAN, 10, 0) },\n" +
            "        { id: 3, point: (CARTESIAN, -2, -2) },\n" +
            "        { id: 4, point: (CARTESIAN, 10, 10) },\n" +
            "    ],\n" +
            "    point: (5, 7),\n" +
            "    maxDistance: 10\n" +
            "}"
        );
    }
}
