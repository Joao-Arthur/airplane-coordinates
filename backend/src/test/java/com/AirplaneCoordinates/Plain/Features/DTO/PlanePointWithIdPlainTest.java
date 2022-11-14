package com.AirplaneCoordinates.Plain.Features.DTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;
import com.AirplaneCoordinates.Plain.Core.Plane.Generic.PlanePointPlain;

public final class PlanePointWithIdPlainTest {
    @Test
    public final void toObject() {
        assertEquals(
            new PlanePointWithIdPlain(
                "AAA",
                new PlanePointPlain(
                    Plane.POLAR,
                    "-1.47",
                    "0.3"
                )
            ).toObject().toString(),
            new PlanePointWithId(
                "AAA",
                PlanePoint.from(
                    Plane.POLAR, 
                    PreciseDecimal.from("-1.47"),
                    PreciseDecimal.from("0.3")
                )
            ).toString()
        );
    }
}
