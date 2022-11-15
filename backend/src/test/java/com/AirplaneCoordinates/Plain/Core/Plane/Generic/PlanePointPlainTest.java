package com.AirplaneCoordinates.Plain.Core.Plane.Generic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PlanePointPlainTest {
    @Test
    public final void toObject() {
        assertEquals(
            new PlanePointPlain(Plane.POLAR, "1.11", "2.22").toObject().toString(),
            PlanePoint.from(
                Plane.POLAR,
                PreciseDecimal.from("1.11"),
                PreciseDecimal.from("2.22")
            ).toString()
        );
    }

    @Test
    public final void fromObject() {
        assertEquals(
            PlanePointPlain.fromObject(
                PlanePoint.from(
                    Plane.POLAR,
                    PreciseDecimal.from("1.11"),
                    PreciseDecimal.from("2.22")
                )
            ).toObject().toString(),
            PlanePoint.from(
                Plane.POLAR,
                PreciseDecimal.from("1.11"),
                PreciseDecimal.from("2.22")
            ).toString()
        );
    }
}
