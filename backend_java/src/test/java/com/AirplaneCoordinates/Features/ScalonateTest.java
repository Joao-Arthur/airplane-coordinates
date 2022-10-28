package com.AirplaneCoordinates.Features;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Disabled;
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
        assertEquals(
            Scalonate.execute(
                PlanePoint.from(Plane.POLAR, 6, 47),
                CartesianPoint.from(0, 0)
            ).value,
            PlanePoint.from(Plane.POLAR, 0, 0).value
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
        assertEquals(
            Scalonate.execute(
                PlanePoint.from(Plane.CARTESIAN, 75, -7),
                CartesianPoint.from(0, 0)
            ).value,
            PlanePoint.from(Plane.CARTESIAN, 0, 0).value
        );
    }

    @ParameterizedTest
    @CsvSource({
        "CARTESIAN, 5, 5, 2, 2",
        "CARTESIAN, 5, 5, -2, -2",
        "CARTESIAN, -5, 5, 2, 2",
        "CARTESIAN, -5, 5, -2, -2",
        "CARTESIAN, 5, -5, 2, 2",
        "CARTESIAN, 5, -5, -2, -2",
        "CARTESIAN, -5, 5, 2, 2",
        "CARTESIAN, 5, 5, 1.5, 1.5",
        "CARTESIAN, -5, 5, 1.5, 1.5",
        "CARTESIAN, 5, -5, 1.5, 1.5",
        "CARTESIAN, -5, 5, 1.5, 1.5",
        "CARTESIAN, 5, -1, 0.1, 0.1",
        "CARTESIAN, 2.22, 3.33, 5.55, -5.55",
        "CARTESIAN, 2.22, 3.33, 5.5, -5.5",
        "CARTESIAN, 5, 5, 0.5, 0.5",
        "CARTESIAN, 0.1, 0.1, 0.1, 0.1",
        "CARTESIAN, -0.1, -0.1, -0.1, -0.1",
        "CARTESIAN, 0, 0, 1, 1",
        //"POLAR, 5, 10, 0.1, 0.1",
        //"POLAR, 5, 45, 2, 2",
        "POLAR, 4, 45, 2, 2",
        "POLAR, 4, 135, -2, 2",
        "POLAR, 4, 225, -2, -2",
        "POLAR, 4, 315, 2, -2",
        //"POLAR, 5, 45, 2, 2",
        //"POLAR, 5, 135, -2, 2",
        //"POLAR, 5, 225, -2, -2",
        //"POLAR, 5, 315, 2, -2",
        "POLAR, 5, 10, 0.4, 0.4",
        "POLAR, 2.22, 38, 5.55, -5.55",
        "POLAR, 5, 75, 0.5, 0.5",
        "POLAR, 7, 135, -2.22, 2.22",
        "POLAR, 0, 0, 1, 1",
        //"POLAR, 5, 0, 5.55, -7",
        "POLAR, 5, 0, 5.5, -7",
        "POLAR, 2, 90, 0.11, 0.11",
        "POLAR, 7.11, 180, -1, -0.28",
        "POLAR, 3, 270, 1, -0.28"
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
        final var pointAfter = Scalonate.execute(movedPoint, factor.reverse());
        assertEquals(pointAfter.value, pointBefore.value);
    }

    @Test
    public final void backAndForthCartesian() {
        final var valuesDouble = new Double[] {
            -1.0, -0.8, -0.5, -0.4, -0.2, -0.1, 0.1, 0.2, 0.4, 0.5, 0.8, 1.0
        };

        for (int i = 0; i < valuesDouble.length; i++) {
            for (int j = 0; j < valuesDouble.length; j++) {
                for (int k = 0; k < valuesDouble.length; k++) {
                    for (int l = 0; l < valuesDouble.length; l++) {
                        final var pointBefore = PlanePoint.from(
                            Plane.CARTESIAN,
                            new BigDecimal(valuesDouble[i]).stripTrailingZeros().toPlainString(),
                            new BigDecimal(valuesDouble[j]).stripTrailingZeros().toPlainString()
                        );
                        final var factor = CartesianPoint.from(
                            String.valueOf(valuesDouble[k]),
                            String.valueOf(valuesDouble[l])
                        );
                        final var movedPoint = Scalonate.execute(
                            pointBefore,
                            factor
                        );
                        final var pointAfter = Scalonate.execute(
                            movedPoint,
                            factor.reverse()
                        );
                        assertEquals(
                            pointAfter.value,
                            pointBefore.value
                        );
                    }
                }
            }
        }

        final var valuesIntValues = new Double[] {
            -10.0, -9.5, -8.0, -5.0, -4.0, -2.5, -2.0, -1.0,
            1.0, 2.0, 2.5, 4.0, 5.0, 8.0, 9.5, 10.0
        };

        for (int i = 0; i < valuesIntValues.length; i++) {
            for (int j = 0; j < valuesIntValues.length; j++) {
                for (int k = 0; k < valuesIntValues.length; k++) {
                    for (int l = 0; l < valuesIntValues.length; l++) {
                        final var pointBefore = PlanePoint.from(
                            Plane.CARTESIAN,
                            new BigDecimal(valuesIntValues[i]).stripTrailingZeros().toPlainString(),
                            new BigDecimal(valuesIntValues[j]).stripTrailingZeros().toPlainString()
                        );
                        final var factor = CartesianPoint.from(
                            String.valueOf(valuesIntValues[k]),
                            String.valueOf(valuesIntValues[l])
                        );
                        final var movedPoint = Scalonate.execute(
                            pointBefore,
                            factor
                        );
                        final var pointAfter = Scalonate.execute(
                            movedPoint,
                            factor.reverse()
                        );
                        assertEquals(
                            pointAfter.value,
                            pointBefore.value
                        );
                    }
                }
            }
        }
    }
}
