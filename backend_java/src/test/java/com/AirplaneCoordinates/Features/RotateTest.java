package com.AirplaneCoordinates.Features;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class RotateTest {
    @Test
    public final void polarRotate() {
        assertEquals(
            Rotate.execute(
                PlanePoint.from(Plane.POLAR, "1.22", "11.11"),
                CartesianPoint.from(0, 0),
                PreciseDecimal.from(50)
            ).value,
            PlanePoint.from(Plane.POLAR, "1.22", "61.11").value
        );
    }
    
    @Test
    public final void polarRotateOffseted() {
        assertEquals(
            Rotate.execute(
                PlanePoint.from(Plane.POLAR, 4, 90),
                CartesianPoint.from(4, 4),
                PreciseDecimal.from(90)
            ).value,
            PlanePoint.from(Plane.POLAR, 4, 0).value
        );
        assertEquals(
            Rotate.execute(
                PlanePoint.from(Plane.POLAR, 4, 45),
                CartesianPoint.from(8, 8),
                PreciseDecimal.from(180)
            ).value,
            PlanePoint.from(
                Plane.POLAR,
                "18.62741699796952078082701958735516925711475000603116917082687580785171965539371262160620054924226516",
                "45"
            ).value
        );
    }

    @Test
    public final void cartesianRotate() {
        assertEquals(
            Rotate.execute(
                PlanePoint.from(Plane.CARTESIAN, 4, 4),
                CartesianPoint.from(8, 0),
                PreciseDecimal.from(90)
            ).value,
            PlanePoint.from(Plane.CARTESIAN, 4, -4).value
        );
    }

    @Test
    public final void cartesianRotateOffseted() {
        assertEquals(
            Rotate.execute(
                PlanePoint.from(Plane.CARTESIAN, 0, 4),
                CartesianPoint.from(4, 4),
                PreciseDecimal.from(90)
            ).value,
            PlanePoint.from(Plane.CARTESIAN, 4, 0).value
        );
        assertEquals(
            Rotate.execute(
                PlanePoint.from(Plane.CARTESIAN, -4, 4),
                CartesianPoint.from(-8, 4),
                PreciseDecimal.from(270)
            ).value,
            PlanePoint.from(Plane.CARTESIAN, -8, 0).value
        );
    }

    @ParameterizedTest()
    @CsvSource({
        //Cartesian
        "CARTESIAN, 0, 0, 0, 0, 90",
        "CARTESIAN, 5, 0, 0, 0, 90",
        "CARTESIAN, 0, 5, 0, 0, 90",
        "CARTESIAN, -5, 0, 0, 0, 90",
        "CARTESIAN, 0, -5, 0, 0, 90",
        //"CARTESIAN, 5, 5, 0, 0, 90",
        "CARTESIAN, -5, 5, 0, 0, 90",
        "CARTESIAN, -5, -5, 0, 0, 90",
        "CARTESIAN, 5, -5, 0, 0, 90",
        "CARTESIAN, 1, 1, 0, 0, 90",
        //"CARTESIAN, 2, 2, 0, 0, 90",
        //"CARTESIAN, 3, 3, 0, 0, 90",
        //"CARTESIAN, 4, 4, 0, 0, 90",
        //"CARTESIAN, 5, 5, 0, 0, 90",
        "CARTESIAN, 1, 1, 0, 0, 11",
        //"CARTESIAN, 2, 2, 0, 0, 11",
        //"CARTESIAN, 3, 3, 0, 0, 11",
        //"CARTESIAN, 4, 4, 0, 0, 11",
        //"CARTESIAN, 5, 5, 0, 0, 11",
        "CARTESIAN, 1, 0, 0, 0, 11",
        "CARTESIAN, 2, 0, 0, 0, 11",
        "CARTESIAN, 3, 0, 0, 0, 11",
        "CARTESIAN, 4, 0, 0, 0, 11",
        "CARTESIAN, 5, 0, 0, 0, 11",
        //Cartesian offseted
        "CARTESIAN, 2, 2, 2, 2, 90",
        "CARTESIAN, 4, 4, 4, 4, 90",
        "CARTESIAN, 2, 0, 2, 2, 90",
        "CARTESIAN, 4, 2, 2, 2, 90",
        "CARTESIAN, 2, 4, 2, 2, 90",
        "CARTESIAN, 0, 2, 2, 2, 90",
        "CARTESIAN, 4, 0, 4, 4, 90",
        "CARTESIAN, 8, 4, 4, 4, 90",
        "CARTESIAN, 4, 8, 4, 4, 90",
        "CARTESIAN, 0, 4, 4, 4, 90",
        //Polar
        "POLAR, 0, 0, 0, 0, 90",
        "POLAR, 7, 0, 0, 0, 90",
        "POLAR, 7, 90, 0, 0, 90",
        "POLAR, 7, 180, 0, 0, 90",
        "POLAR, 7, 270, 0, 0, 90",
        //"POLAR, 3, 45, 0, 0, 90",
        "POLAR, 3, 135, 0, 0, 90",
        "POLAR, 3, 225, 0, 0, 90",
        //"POLAR, 3, 315, 0, 0, 90",
        "POLAR, 1, 45, 0, 0, 90",
        "POLAR, 2, 45, 0, 0, 90",
        //"POLAR, 3, 45, 0, 0, 90",
        //"POLAR, 4, 45, 0, 0, 90",
        //"POLAR, 5, 45, 0, 0, 90",
        "POLAR, 1, 45, 0, 0, 11",
        "POLAR, 2, 45, 0, 0, 11",
        //"POLAR, 3, 45, 0, 0, 11",
        "POLAR, 4, 45, 0, 0, 11",
        //"POLAR, 5, 45, 0, 0, 11",
        "POLAR, 1, 0, 0, 0, 11",
        "POLAR, 2, 0, 0, 0, 11",
        "POLAR, 3, 0, 0, 0, 11",
        "POLAR, 4, 0, 0, 0, 11",
        "POLAR, 5, 0, 0, 0, 11",
        //Polar offseted
        //"POLAR, 2, 45, 2, 2, 90",
        //"POLAR, 4, 45, 4, 4, 90",
        //"POLAR, 1, 10, 4, 4, 90",
        //"POLAR, 2, 20, 4, 4, 90",
        //"POLAR, 3, 30, 4, 4, 90",
        //"POLAR, 4, 40, 4, 4, 90",
        //"POLAR, 5, 45, 4, 4, 90",
        //"POLAR, 6, 50, 4, 4, 90",
        //"POLAR, 7, 60, 4, 4, 90",
        "POLAR, 1, 0, 1, 1, 90",
        "POLAR, 1, 90, 1, 1, 90",
        "POLAR, 2, 0, 2, 2, 90",
        "POLAR, 2, 90, 2, 2, 90",
        //"POLAR, 3, 0, 3, 3, 90",
        //"POLAR, 3, 90, 3, 3, 90",
        //"POLAR, 4, 0, 4, 4, 90",
        //"POLAR, 4, 90, 4, 4, 90",
    })
    public final void rotateBackAndForth(
        final Plane plane,
        final String pointX,
        final String pointY,
        final String centerX,
        final String centerY,
        final String angle
    ) {
        final var pointBefore = PlanePoint.from(plane, pointX, pointY);
        final var centerOfRotation = CartesianPoint.from(centerX, centerY);
        final var angleValue = PreciseDecimal.from(angle);
        final var movedPoint = Rotate.execute(pointBefore, centerOfRotation, angleValue);
        final var pointAfter = Rotate.execute(movedPoint, centerOfRotation, angleValue.opposite());
        assertEquals(pointAfter.value, pointBefore.value);
    }
}
