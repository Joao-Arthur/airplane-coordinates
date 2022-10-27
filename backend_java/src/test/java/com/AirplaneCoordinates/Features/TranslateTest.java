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

    @Test
    public final void backAndForth1() {
        final var pointAfterMove = Translate.execute(
            PlanePoint.from(Plane.CARTESIAN, 5, -1),
            CartesianPoint.from("0.1", "0.1")
        );
        final var pointAfterMoveBack = Translate.execute(
            pointAfterMove,
            CartesianPoint.from("-0.1", "-0.1")
        );
        assertEquals(
            pointAfterMoveBack.value,
            PlanePoint.from(Plane.CARTESIAN, 5, -1).value
        );
    }

    @Test
    public final void backAndForth2() {
        final var pointAfterMove = Translate.execute(
            PlanePoint.from(Plane.CARTESIAN, "2.22", "3.33"),
            CartesianPoint.from("5.55", "-5.55")
        );
        final var pointAfterMoveBack = Translate.execute(
            pointAfterMove,
            CartesianPoint.from("-5.55", "5.55")
        );
        assertEquals(
            pointAfterMoveBack.value,
            PlanePoint.from(Plane.CARTESIAN, "2.22", "3.33").value
        );
    }

    @Test
    public final void backAndForth3() {
        final var pointAfterMove = Translate.execute(
            PlanePoint.from(Plane.CARTESIAN, "5", "5"),
            CartesianPoint.from("0.5", "0.5")
        );
        final var pointAfterMoveBack = Translate.execute(
            pointAfterMove,
            CartesianPoint.from("-0.5", "-0.5")
        );
        assertEquals(
            pointAfterMoveBack.value,
            PlanePoint.from(Plane.CARTESIAN, "5", "5").value
        );
    }
}
