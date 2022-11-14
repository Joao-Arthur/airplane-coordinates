package com.AirplaneCoordinates.Plain.Features.DTO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Mechanics.Vector;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithVector;
import com.AirplaneCoordinates.Plain.Core.Mechanics.VectorPlain;
import com.AirplaneCoordinates.Plain.Core.Plane.Generic.PlanePointPlain;

public final class PlanePointWithVectorPlainTest {
    @Test
    public final void toObject() {
        assertEquals(
            new PlanePointWithVectorPlain(
                "AAA",
                new PlanePointPlain(
                    Plane.CARTESIAN,
                    "1.03",
                    "-4"
                ),
                new VectorPlain("0", "-2")
            ).toObject().toString(),
            new PlanePointWithVector(
                "AAA",
                PlanePoint.from(
                    Plane.CARTESIAN, 
                    PreciseDecimal.from("1.03"),
                    PreciseDecimal.from("-4")
                ),
                Vector.from(
                    PreciseDecimal.from(0),
                    PreciseDecimal.from(-2)
                )
            ).toString()
        );
    }
}
