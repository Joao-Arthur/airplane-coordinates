package com.AirplaneCoordinates.Features;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class ScalonateTest {
    @Test
    public final void polarScalonate() {
        assertEquals(
            Scalonate.execute(
                PlanePoint.from(Plane.POLAR, 1, 0),
                CartesianPoint.from(-2, 0)
            ).value,
            PlanePoint.from(Plane.POLAR, 2, 180).value
        );
        assertEquals(
            Scalonate.execute(
                PlanePoint.from(Plane.POLAR, 1, 45),
                CartesianPoint.from(2, 2)
            ).value,
            PlanePoint.from(Plane.POLAR, 2, 45).value
        );
        assertEquals(
            Scalonate.execute(
                PlanePoint.from(Plane.POLAR, 100, 60),
                CartesianPoint.from("0.5", "0.5")
            ).value,
            PlanePoint.from(Plane.POLAR, 50, 60).value
        );
        assertEquals(
            Scalonate.execute(
                PlanePoint.from(Plane.POLAR, 100, 60),
                CartesianPoint.from("1", "0.5")
            ).value,
            PlanePoint.from(
                Plane.POLAR,
                "66.14378277661476476254039384098151064275647957706125450920836148002672058075709069400982216186359028",
                "40.8933946491309056054825252598699177650239247701694879239436224278406825108096473833900705055539013"
            ).value
        );
    }

    @Test
    public final void cartesianScalonate() {
        assertEquals(
            Scalonate.execute(
                PlanePoint.from(Plane.CARTESIAN, 5, -1),
                CartesianPoint.from(-2, 2)
            ).value,
            PlanePoint.from(Plane.CARTESIAN, -10, -2).value
        );
        assertEquals(
            Scalonate.execute(
                PlanePoint.from(Plane.CARTESIAN, 479001600, -479001600),
                CartesianPoint.from("-0.5", "0.5")
            ).value,
            PlanePoint.from(Plane.CARTESIAN, "-239500800", "-239500800").value
        );
    }

/*   @ParameterizedTest()
    @CsvSource({
        "CARTESIAN, 5, -1, 0.1, 0.1",
        "CARTESIAN, 2.22, 3.33, 5,55, -5.55",
        "CARTESIAN, 5, 5, 0.5, 0.5",
        "CARTESIAN, 0.1, 0.1, 0.1, 0.1",
        "CARTESIAN, -0.1, -0.1, -0.1, -0.1",
        "CARTESIAN, 0, 0, 0, 0",
        //"POLAR, 5, 10, 0.1, 0.1",
        //"POLAR, 2.22, 38, 5,55, -5.55",
        //"POLAR, 5, 75, 0.5, 0.5",
        //"POLAR, 7, 135, -2.22, 2.22",
        "POLAR, 0, 0, 0, 0",
        "POLAR, 5, 0, 5.55, 0",
        "POLAR, 2, 90, 0, 0.11",
        "POLAR, 7.11, 180, 0, -0.28",
        "POLAR, 3, 270, 0, -0.28"
    })
    public final void scalonateBackAndForth(
        final Plane plane,
        final String pointX,
        final String pointY,
        final String factorX,
        final String factorY
    ) {
        final var pointBefore = PlanePoint.from(plane, pointX, pointY);
        final var factor = CartesianPoint.from(factorX, factorY);
        final var movedPoint = Scalonate.execute(pointBefore, factor);
        final var pointAfter = Translate.execute(movedPoint, factor.opposite());
        assertEquals(pointAfter.value, pointBefore.value);
    }*/
}
