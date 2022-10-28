package com.AirplaneCoordinates.Features;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
                "2.414213562373095048801688724209698078569671875376948073176679737990732478462107038850387534327641572",
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

    @ParameterizedTest()
    @CsvSource({
        "CARTESIAN, 5, -1, 0.1, 0.1",
        "CARTESIAN, 2.22, 3.33, 5.55, -5.55",
        "CARTESIAN, 5, 5, 0.5, 0.5",
        "CARTESIAN, 0.1, 0.1, 0.1, 0.1",
        "CARTESIAN, -0.1, -0.1, -0.1, -0.1",
        "CARTESIAN, 0, 0, 0, 0",
        //"POLAR, 5, 10, 0.1, 0.1",
        //"POLAR, 5, 10, 0.2, 0.2",
        //"POLAR, 5, 10, 0.4, 0.4",
        //"POLAR, 5, 10, 0.5, 0.5",
        //"POLAR, 2.22, 38, 5.55, -5.55",
        //"POLAR, 2.22, 38, 5.5, -5.5",
        //"POLAR, 2.2, 38, 5.5, -5.5",
        //"POLAR, 2, 38, 5, -5",
        //"POLAR, 2.2, 38, 5, -5",
        //"POLAR, 5, 75, 0.5, 0.5",
        //"POLAR, 5, 75, 1, 1",
        //"POLAR, 7, 135, -2.22, 2.22",
        //"POLAR, 7, 135, -2.2, 2.2",
        //"POLAR, 7, 135, -4, 4",
        "POLAR, 0, 0, 0, 0",
        //"POLAR, 5, 0, 5.55, 0",
        "POLAR, 5, 0, 5.5, 0",
        "POLAR, 2, 90, 0, 0.11",
        "POLAR, 7.11, 180, 0, -0.28",
        "POLAR, 3, 270, 0, -0.28"
    })
    public final void backAndForth(
        final Plane plane,
        final String pointX,
        final String pointY,
        final String factorX,
        final String factorY
    ) {
        final var pointBefore = PlanePoint.from(plane, pointX, pointY);
        final var factor = CartesianPoint.from(factorX, factorY);
        final var movedPoint = Translate.execute(pointBefore, factor);
        final var pointAfter = Translate.execute(movedPoint, factor.opposite());
        assertEquals(pointAfter.value, pointBefore.value);
    }
}
