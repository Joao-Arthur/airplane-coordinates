package com.AirplaneCoordinates.Plain.Features.Rotate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Features.Rotate.RotateOutputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Generic.PlanePointPlain;

public final class RotateOutputDTOPlainTest {
    @Test
    public static final void toObject() {
        assertEquals(
            new RotateOutputDTOPlain(
                new PlanePointPlain(Plane.POLAR, "1", "2")
            ).toObject().toString(),
            new RotateOutputDTO(PlanePoint.from(Plane.POLAR, 1, 2)).toString()
        );
    }

    @Test
    public static final void fromObject() {
        assertEquals(
            RotateOutputDTOPlain.fromObject(
                new RotateOutputDTO(PlanePoint.from(Plane.POLAR, 1, 2))
            ).toObject().toString(),
            new RotateOutputDTO(PlanePoint.from(Plane.POLAR, 1, 2)).toString()
        );
    }
}
