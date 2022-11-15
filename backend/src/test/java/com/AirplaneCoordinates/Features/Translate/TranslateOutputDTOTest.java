package com.AirplaneCoordinates.Features.Translate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.List.CustomArrayList;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class TranslateOutputDTOTest {
    @Test
    public final void toStringTest() {
        assertEquals(
            new TranslateOutputDTO(
                new CustomArrayList<PlanePointWithId>()
                    .insert(new PlanePointWithId("d", PlanePoint.from(Plane.POLAR, 1, 0)))
            ).toString(),
            "{\n" +
            "    points: [\n" +
            "        { id: d, point: (POLAR, 1, 0) },\n" +
            "    ]\n" +
            "}"
        );
    }
}
