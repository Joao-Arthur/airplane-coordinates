package com.AirplaneCoordinates.Plain.Features.Scalonate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Features.Scalonate.ScalonateOutputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Generic.PlanePointPlain;

public final class ScalonateOutputDTOPlainTest {
    @Test
    public static final void toObject() {
        assertEquals(
            new ScalonateOutputDTOPlain(
                new PlanePointPlain(Plane.POLAR, "1", "2")
            ).toObject().toString(),
            new ScalonateOutputDTO(PlanePoint.from(Plane.POLAR, 1, 2)).toString()
        );
    }

    @Test
    public static final void fromObject() {
        assertEquals(
            ScalonateOutputDTOPlain.fromObject(
                new ScalonateOutputDTO(PlanePoint.from(Plane.POLAR, 1, 2))
            ).toObject().toString(),
            new ScalonateOutputDTO(PlanePoint.from(Plane.POLAR, 1, 2)).toString()
        );
    }
}
