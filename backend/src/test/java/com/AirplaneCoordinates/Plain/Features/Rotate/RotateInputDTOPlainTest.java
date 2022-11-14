package com.AirplaneCoordinates.Plain.Features.Rotate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.Rotate.RotateInputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Cartesian.CartesianPointPlain;
import com.AirplaneCoordinates.Plain.Core.Plane.Generic.PlanePointPlain;

public final class RotateInputDTOPlainTest {
    @Test
    public final void toObject() {
        assertEquals(
            new RotateInputDTOPlain(
                new PlanePointPlain(
                    Plane.CARTESIAN,
                    "7",
                    "0"
                ),
                new CartesianPointPlain(
                    "0.2",
                    "7.7"
                ),
                "200.02"
            ).toObject().toString(),
            new RotateInputDTO(
                PlanePoint.from(
                    Plane.CARTESIAN,
                    PreciseDecimal.from(7),
                    PreciseDecimal.from(0)
                ),
                CartesianPoint.from(
                    PreciseDecimal.from("0.2"),
                    PreciseDecimal.from("7.7")
                ),
                PreciseDecimal.from("200.02")
            ).toString()
        );
    }
}
