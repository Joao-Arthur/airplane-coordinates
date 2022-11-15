package com.AirplaneCoordinates.Plain.Features.PointsCloseToEachOther;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PointsCloseToEachOther.PointCloseToEachOtherOutputDTO;

public final class PointCloseToEachOtherOutputDTOPlainTest {
    @Test
    public static final void toObject() {
        assertEquals(
            new PointCloseToEachOtherOutputDTOPlain(
                "A",
                "B",
                "7.37"
            ).toObject().toString(),
            new PointCloseToEachOtherOutputDTO(
                "A",
                "B",
                PreciseDecimal.from("7.37")
            ).toString()
        );
    }

    @Test
    public static final void fromObject() {
        assertEquals(
            PointCloseToEachOtherOutputDTOPlain.fromObject(
                new PointCloseToEachOtherOutputDTO(
                    "J",
                    "Z",
                    PreciseDecimal.from("-0.28")
                )
            ).toObject().toString(),
            new PointCloseToEachOtherOutputDTO(
                "J",
                "Z",
                PreciseDecimal.from("-0.28")
            ).toString()
        );
    }
}
