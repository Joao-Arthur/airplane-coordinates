 package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Mechanics.Vector;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithVector;

public final class PointsInRouteOfCollisionInputDTOTest {
    @Test
    public final void toStringTest() {
        final var points = new ArrayList<PlanePointWithVector>();
        points.add(new PlanePointWithVector("3", PlanePoint.from(Plane.POLAR, 1, 180), Vector.from(186, 1)));
        points.add(new PlanePointWithVector("5", PlanePoint.from(Plane.CARTESIAN, -1, 0), Vector.from(17, 9)));
        points.add(new PlanePointWithVector("7", PlanePoint.from(Plane.CARTESIAN, -2, 0), Vector.from(45, 1)));
        points.add(new PlanePointWithVector("9", PlanePoint.from(Plane.CARTESIAN, 2, 0), Vector.from(135, 2)));

        final var dto = new PointsInRouteOfCollisionInputDTO(points, PreciseDecimal.from(10));

        assertEquals(
            dto.toString(),
            "{\n" +
            "    points: [\n" +
            "        { id: 3, point: (POLAR, 1, 180), vector: (186º, 1 km/h) },\n" +
            "        { id: 5, point: (CARTESIAN, -1, 0), vector: (17º, 9 km/h) },\n" +
            "        { id: 7, point: (CARTESIAN, -2, 0), vector: (45º, 1 km/h) },\n" +
            "        { id: 9, point: (CARTESIAN, 2, 0), vector: (135º, 2 km/h) },\n" +
            "    ],\n" +
            "    maxTime: 10\n" +
            "}"
        );
    }
}
