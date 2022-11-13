package com.AirplaneCoordinates.Features.Scalonate;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class ScalonateServiceTest {
    @Test
    public final void polarScalonate() {
        assertEquals(
            new ScalonateService(
                new ScalonateInputDTO(
                    PlanePoint.from(Plane.POLAR, 1, 0),
                    CartesianPoint.from(-2, 0)
                )
            ).execute().toString(),
            new ScalonateOutputDTO(PlanePoint.from(Plane.POLAR, 2, 180)).toString()
        );
        assertEquals(
            new ScalonateService(
                new ScalonateInputDTO(
                    PlanePoint.from(Plane.POLAR, 1, 45),
                    CartesianPoint.from(2, 2)
                )
            ).execute().toString(),
            new ScalonateOutputDTO(PlanePoint.from(Plane.POLAR, 2, 45)).toString()
        );
        assertEquals(
            new ScalonateService(
                new ScalonateInputDTO(
                    PlanePoint.from(Plane.POLAR, 100, 60),
                    CartesianPoint.from("0.5", "0.5")
                )
            ).execute().toString(),
            new ScalonateOutputDTO(PlanePoint.from(Plane.POLAR, 50, 60)).toString()
        );
        assertEquals(
            new ScalonateService(
                new ScalonateInputDTO(
                    PlanePoint.from(Plane.POLAR, 100, 60),
                    CartesianPoint.from("1", "0.5")
                )
            ).execute().toString(),
            new ScalonateOutputDTO(
                PlanePoint.from(
                    Plane.POLAR,
                    "66.14378277661476476254039384098151064275647957706125450920836148002672058075709069400982216186359028",
                    "40.8933946491309056054825252598699177650239247701694879239436224278406825108096473833900705055539013"
                )
            ).toString()
        );
        assertEquals(
            new ScalonateService(
                new ScalonateInputDTO(
                    PlanePoint.from(Plane.POLAR, 6, 47),
                    CartesianPoint.from(0, 0)
                )
            ).execute().toString(),
            new ScalonateOutputDTO(
                PlanePoint.from(Plane.POLAR, 0, 0)
            ).toString()
        );
    }

    @Test
    public final void cartesianScalonate() {
        assertEquals(
            new ScalonateService(
                new ScalonateInputDTO(
                    PlanePoint.from(Plane.CARTESIAN, 5, -1),
                    CartesianPoint.from(-2, 2)
                )
            ).execute().toString(),
            new ScalonateOutputDTO(
                PlanePoint.from(Plane.CARTESIAN, -10, -2)
            ).toString()
        );
        assertEquals(
            new ScalonateService(
                new ScalonateInputDTO(
                    PlanePoint.from(Plane.CARTESIAN, 479001600, -479001600),
                    CartesianPoint.from("-0.5", "0.5")
                )
            ).execute().toString(),
            new ScalonateOutputDTO(
                PlanePoint.from(Plane.CARTESIAN, "-239500800", "-239500800")
            ).toString()
        );
        assertEquals(
            new ScalonateService(
                new ScalonateInputDTO(
                    PlanePoint.from(Plane.CARTESIAN, 75, -7),
                    CartesianPoint.from(0, 0)
                )
            ).execute().toString(),
            new ScalonateOutputDTO(
                PlanePoint.from(Plane.CARTESIAN, 0, 0)
            ).toString()
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
        "POLAR, 5, 10, 0.1, 0.1",
        "POLAR, 5, 45, 2, 2",
        "POLAR, 4, 45, 2, 2",
        "POLAR, 4, 135, -2, 2",
        "POLAR, 4, 225, -2, -2",
        "POLAR, 4, 315, 2, -2",
        "POLAR, 5, 45, 2, 2",
        "POLAR, 5, 135, -2, 2",
        "POLAR, 5, 225, -2, -2",
        "POLAR, 5, 315, 2, -2",
        "POLAR, 5, 10, 0.4, 0.4",
        "POLAR, 2.22, 38, 5.55, -5.55",
        "POLAR, 5, 75, 0.5, 0.5",
        "POLAR, 7, 135, -2.22, 2.22",
        "POLAR, 0, 0, 1, 1",
        "POLAR, 5, 0, 5.55, -7",
        "POLAR, 5, 0, 5.5, -7",
        "POLAR, 2, 90, 0.11, 0.11",
        "POLAR, 7.11, 180, -1, -0.28",
        "POLAR, 3, 270, 1, -0.28"
    })
    @Tag("moderate")
    public final void scalonateBackAndForth(
        final Plane plane,
        final String pointX,
        final String pointY,
        final String factorX,
        final String factorY
    ) {
        final var pointBefore = new ScalonateOutputDTO(
            PlanePoint.from(plane, pointX, pointY)
        );
        final var factor = CartesianPoint.from(factorX, factorY);
        final var movedPoint = new ScalonateService(
            new ScalonateInputDTO(
                pointBefore.point,
                factor
            )
        ).execute();
        final var pointAfter = new ScalonateService(
            new ScalonateInputDTO(
                movedPoint.point,
                factor.reverse()
            )
        ).execute();
        assertEquals(pointAfter.toString(), pointBefore.toString());
    }

    @Test
    @Tag("slow")
    public final void backAndForthCartesianSlow() {
        final var values = new String[] {
            "-1", "-0.8", "-0.5", "-0.4", "-0.2", "-0.1",
            "0.1", "0.2", "0.4", "0.5", "0.8", "1"
        };

        for (float pointX = -10f; pointX <= 10f; pointX += 0.1f) {
            for (float pointY = -10f; pointY <= 10f; pointY += 0.1f) {
                for (int i = 0; i < values.length; i++) {
                    for (int j = 0; j < values.length; j++) {
                        final var pointBefore = new ScalonateOutputDTO(
                            PlanePoint.from(
                                Plane.CARTESIAN,
                                new BigDecimal(pointX).stripTrailingZeros().toPlainString(),
                                new BigDecimal(pointY).stripTrailingZeros().toPlainString()
                            )
                        );
                        final var factor = CartesianPoint.from(
                            values[i],
                            values[j]
                        );
                        final var movedPoint = new ScalonateService(
                            new ScalonateInputDTO(
                                pointBefore.point,
                                factor
                            )
                        ).execute();
                        final var pointAfter = new ScalonateService(
                            new ScalonateInputDTO(
                                movedPoint.point,
                                factor.reverse()
                            )
                        ).execute();
                        assertEquals(
                            pointAfter.toString(),
                            pointBefore.toString()
                        );
                    }
                }
            }
        }
    }

    @Test
    @Tag("moderate")
    public final void backAndForthCartesian() {
        final var values = new String[] {
            "-1", "-0.8", "-0.5", "-0.4", "-0.2", "-0.1",
            "0.1", "0.2", "0.4", "0.5", "0.8", "1"
        };
        final var otherValues = new String[] {
            "-10", "-9.5", "-8", "-5",
            "-4", "-2.5", "-2", "-1",
            "1", "2", "2.5", "4",
            "5", "8", "9.5", "10"
        };

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                for (int k = 0; k < values.length; k++) {
                    for (int l = 0; l < values.length; l++) {
                        final var pointBefore = new ScalonateOutputDTO(
                            PlanePoint.from(
                                Plane.CARTESIAN,
                                values[i],
                                values[j]
                            )
                        );
                        final var factor = CartesianPoint.from(
                            values[k],
                            values[l]
                        );
                        final var movedPoint = new ScalonateService(
                            new ScalonateInputDTO(
                                pointBefore.point,
                                factor
                            )
                        ).execute();
                        final var pointAfter = new ScalonateService(
                            new ScalonateInputDTO(
                                movedPoint.point,
                                factor.reverse()
                            )
                        ).execute();
                        assertEquals(
                            pointAfter.toString(),
                            pointBefore.toString()
                        );
                    }
                }
            }
        }

        for (float pointX = -1f; pointX <= 1f; pointX += 0.1f) {
            for (float pointY = -1f; pointY <= 1f; pointY += 0.1f) {
                for (int i = 0; i < values.length; i++) {
                    for (int j = 0; j < values.length; j++) {
                        final var pointBefore = new ScalonateOutputDTO(
                            PlanePoint.from(
                                Plane.CARTESIAN,
                                new BigDecimal(pointX).stripTrailingZeros().toPlainString(),
                                new BigDecimal(pointY).stripTrailingZeros().toPlainString()
                            )
                        );
                        final var factor = CartesianPoint.from(
                            values[i],
                            values[j]
                        );
                        final var movedPoint = new ScalonateService(
                            new ScalonateInputDTO(
                                pointBefore.point,
                                factor
                            )
                        ).execute();
                        final var pointAfter = new ScalonateService(
                            new ScalonateInputDTO(
                                movedPoint.point,
                                factor.reverse()
                            )
                        ).execute();
                        assertEquals(
                            pointAfter.toString(),
                            pointBefore.toString()
                        );
                    }
                }
            }
        }


        for (int i = 0; i < otherValues.length; i++) {
            for (int j = 0; j < otherValues.length; j++) {
                for (int k = 0; k < otherValues.length; k++) {
                    for (int l = 0; l < otherValues.length; l++) {
                        final var pointBefore = new ScalonateOutputDTO(
                            PlanePoint.from(
                                Plane.CARTESIAN,
                                otherValues[i],
                                otherValues[j]
                            )
                        );
                        final var factor = CartesianPoint.from(
                            otherValues[k],
                            otherValues[l]
                        );
                        final var movedPoint = new ScalonateService(
                            new ScalonateInputDTO(
                                pointBefore.point,
                                factor
                            )
                        ).execute();
                        final var pointAfter = new ScalonateService(
                            new ScalonateInputDTO(
                                movedPoint.point,
                                factor.reverse()
                            )
                        ).execute();
                        assertEquals(
                            pointAfter.toString(),
                            pointBefore.toString()
                        );
                    }
                }
            }
        }
    }
}
