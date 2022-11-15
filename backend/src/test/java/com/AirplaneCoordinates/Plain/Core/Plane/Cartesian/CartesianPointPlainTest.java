package com.AirplaneCoordinates.Plain.Core.Plane.Cartesian;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class CartesianPointPlainTest {
    @Test
    public final void toObject() {
        assertEquals(
            new CartesianPointPlain("1.11", "2.22").toObject().toString(),
            CartesianPoint.from(
                PreciseDecimal.from("1.11"),
                PreciseDecimal.from("2.22")
            ).toString()
        );
    }

    @Test
    public final void fromObject() {
        assertEquals(
            CartesianPointPlain.fromObject(
                CartesianPoint.from(
                    PreciseDecimal.from("1.11"),
                    PreciseDecimal.from("2.22")
                )
            ).toObject().toString(),
            CartesianPoint.from(
                PreciseDecimal.from("1.11"),
                PreciseDecimal.from("2.22")
            ).toString()
        );
    }
}
