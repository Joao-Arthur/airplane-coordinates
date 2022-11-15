package com.AirplaneCoordinates.Plain.Features.PointsCloseToEachOther;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PointsCloseToEachOther.PointCloseToEachOtherOutputDTO;
import com.AirplaneCoordinates.Features.PointsCloseToEachOther.PointsCloseToEachOtherOutputDTO;

public final class PointsCloseToEachOtherOutputDTOPlainTest {
    @Test
    public static final void toObject() {
        final var plainList = new ArrayList<PointCloseToEachOtherOutputDTOPlain>();
        plainList.add(new PointCloseToEachOtherOutputDTOPlain("G", "I", "3.3"));
        plainList.add(new PointCloseToEachOtherOutputDTOPlain("I", "Z", "0"));

        final var objectList = new ArrayList<PointCloseToEachOtherOutputDTO>();
        objectList.add(
            new PointCloseToEachOtherOutputDTO(
                "G",
                "I",
                PreciseDecimal.from("3.3")
            )
        );
        objectList.add(
            new PointCloseToEachOtherOutputDTO(
                "I",
                "Z",
                PreciseDecimal.from("0")
            )
        );
        
        assertEquals(
            new PointsCloseToEachOtherOutputDTOPlain(
                plainList
            ).toObject().toString(),
            new PointsCloseToEachOtherOutputDTO(
                objectList
            ).toString()
        );
    }

    @Test
    public static final void fromObject() {
        final var objectList = new ArrayList<PointCloseToEachOtherOutputDTO>();
        objectList.add(
            new PointCloseToEachOtherOutputDTO(
                "G",
                "I",
                PreciseDecimal.from("3.3")
            )
        );
        objectList.add(
            new PointCloseToEachOtherOutputDTO(
                "I",
                "Z",
                PreciseDecimal.from("0")
            )
        );
        
        assertEquals(
            PointsCloseToEachOtherOutputDTOPlain.fromObject(
                new PointsCloseToEachOtherOutputDTO(objectList)
            ).toObject().toString(),
            new PointsCloseToEachOtherOutputDTO(
                objectList
            ).toString()
        );
    }
}
