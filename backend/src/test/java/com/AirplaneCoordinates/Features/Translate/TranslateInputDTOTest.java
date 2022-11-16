package com.AirplaneCoordinates.Features.Translate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.List.CustomArrayList;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class TranslateInputDTOTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            new TranslateInputDTO(
                new CustomArrayList<PlanePointWithId>()
                    .insert(new PlanePointWithId("1", PlanePoint.from(Plane.CARTESIAN, 10, 10)))
                    .insert(new PlanePointWithId("2", PlanePoint.from(Plane.CARTESIAN, 10, 20)))
                    .insert(new PlanePointWithId("3", PlanePoint.from(Plane.POLAR, 0, 20)))
                    .insert(new PlanePointWithId("4", PlanePoint.from(Plane.POLAR, 2, 22))),
                CartesianPoint.from(-2, 0)
            ).toString(),
            "{\n" +
            "    points: [\n" +
            "        { id: 1, point: (CARTESIAN, 10, 10) },\n" +
            "        { id: 2, point: (CARTESIAN, 10, 20) },\n" +
            "        { id: 3, point: (POLAR, 0, 20) },\n" +
            "        { id: 4, point: (POLAR, 2, 22) },\n" +
            "    ],\n" +
            "    factor: (-2, 0)\n" +
            "}"
        );
    }
}
