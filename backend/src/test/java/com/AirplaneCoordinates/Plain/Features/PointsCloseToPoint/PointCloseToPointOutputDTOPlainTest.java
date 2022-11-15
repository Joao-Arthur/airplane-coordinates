package com.AirplaneCoordinates.Plain.Features.PointsCloseToPoint;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PointsCloseToPoint.PointCloseToPointOutputDTO;

public final class PointCloseToPointOutputDTOPlainTest {
    @Test
    public static final void toObject() {
        assertEquals(
            new PointCloseToPointOutputDTOPlain(
                "B",
                "7.37"
            ).toObject().toString(),
            new PointCloseToPointOutputDTO(
                "B",
                PreciseDecimal.from("7.37")
            ).toString()
        );
    }

    @Test
    public static final void fromObject() {
        assertEquals(
            PointCloseToPointOutputDTOPlain.fromObject(
                new PointCloseToPointOutputDTO(
                    "Z",
                    PreciseDecimal.from("-0.28")
                )
            ).toObject().toString(),
            new PointCloseToPointOutputDTO(
                "Z",
                PreciseDecimal.from("-0.28")
            ).toString()
        );
    }
}
