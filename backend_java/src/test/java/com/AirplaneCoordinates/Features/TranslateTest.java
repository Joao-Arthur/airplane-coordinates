package com.AirplaneCoordinates.Features;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class TranslateTest {
    @Test
    public final void polarTranslate() {
        assertEquals(
            Translate.execute(
                PlanePoint.from(Plane.POLAR, 1, 0),
                CartesianPoint.from(-2, 0)
            ).value,
            PlanePoint.from(Plane.POLAR, 1, 180).value
        );
        assertEquals(
            Translate.execute(
                PlanePoint.from(Plane.POLAR, 1, 45),
                CartesianPoint.from(1, 1)
            ).value,
            PlanePoint.from(
                Plane.POLAR,
                "2.4142135623730950488016887242",
                "45"
            ).value
        );
    }

    @Test
    public final void cartesianTranslate() {
        assertEquals(
            Translate.execute(
                PlanePoint.from(Plane.CARTESIAN, 5, -1),
                CartesianPoint.from(-2, 2)
            ).value,
            PlanePoint.from(Plane.CARTESIAN, 3, 1).value
        );
    }
}
