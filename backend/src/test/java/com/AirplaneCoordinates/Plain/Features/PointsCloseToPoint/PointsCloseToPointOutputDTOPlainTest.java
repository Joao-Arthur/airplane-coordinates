package com.AirplaneCoordinates.Plain.Features.PointsCloseToPoint;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PointsCloseToPoint.PointCloseToPointOutputDTO;
import com.AirplaneCoordinates.Features.PointsCloseToPoint.PointsCloseToPointOutputDTO;

public final class PointsCloseToPointOutputDTOPlainTest {
    @Test
    public static final void toObject() {
        final var plainList = new ArrayList<PointCloseToPointOutputDTOPlain>();
        plainList.add(new PointCloseToPointOutputDTOPlain("I", "3.3"));
        plainList.add(new PointCloseToPointOutputDTOPlain("Z", "0"));

        final var objectList = new ArrayList<PointCloseToPointOutputDTO>();
        objectList.add(
            new PointCloseToPointOutputDTO(
                "I",
                PreciseDecimal.from("3.3")
            )
        );
        objectList.add(
            new PointCloseToPointOutputDTO(
                "Z",
                PreciseDecimal.from("0")
            )
        );
        
        assertEquals(
            new PointsCloseToPointOutputDTOPlain(
                plainList
            ).toObject().toString(),
            new PointsCloseToPointOutputDTO(
                objectList
            ).toString()
        );
    }

    @Test
    public static final void fromObject() {
        final var objectList = new ArrayList<PointCloseToPointOutputDTO>();
        objectList.add(
            new PointCloseToPointOutputDTO(
                "G",
                PreciseDecimal.from("3.3")
            )
        );
        objectList.add(
            new PointCloseToPointOutputDTO(
                "Z",
                PreciseDecimal.from("0")
            )
        );
        
        assertEquals(
            PointsCloseToPointOutputDTOPlain.fromObject(
                new PointsCloseToPointOutputDTO(objectList)
            ).toObject().toString(),
            new PointsCloseToPointOutputDTO(
                objectList
            ).toString()
        );
    }
}
