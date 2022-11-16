package com.AirplaneCoordinates.Features.Rotate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.List.CustomArrayList;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class RotateOutputDTOTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            new RotateOutputDTO(
                new CustomArrayList<PlanePointWithId>()
                    .insert(new PlanePointWithId("d", PlanePoint.from(Plane.CARTESIAN, 7, 86)))
            ).toString(),
            "{\n" +
            "    points: [\n" +
            "        { id: d, point: (CARTESIAN, 7, 86) },\n" +
            "    ]\n" +
            "}"
        );
    }
}
