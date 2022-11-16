package com.AirplaneCoordinates.Features.PointsCloseToEachOther;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.List.CustomArrayList;
import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class PointsCloseToEachOtherServiceTest {
    @Test
    public final void pointsCloseToPoint() {
        assertEquals(
            new PointsCloseToEachOtherService(
                new PointsCloseToEachOtherInputDTO(
                    new CustomArrayList<PlanePointWithId>()
                        .insert(new PlanePointWithId("1", PlanePoint.from(Plane.CARTESIAN, 10, 10)))
                        .insert(new PlanePointWithId("2", PlanePoint.from(Plane.CARTESIAN, 10, 20)))
                        .insert(new PlanePointWithId("3", PlanePoint.from(Plane.CARTESIAN, 0, 20)))
                        .insert(new PlanePointWithId("4", PlanePoint.from(Plane.CARTESIAN, 2, 22))),
                    PreciseDecimal.from(10)
                )
            ).execute().toString(),
            new PointsCloseToEachOtherOutputDTO(
                new CustomArrayList<PointCloseToEachOtherOutputDTO>()
                    .insert(
                        new PointCloseToEachOtherOutputDTO(
                            "3",
                            "4",
                            PreciseDecimal.from("2.828427124746190097603377448419396157139343750753896146353359475981464956924214077700775068655283145")
                        )
                    )
                    .insert(
                        new PointCloseToEachOtherOutputDTO(
                            "2",
                            "4",
                            PreciseDecimal.from("8.246211251235321099642819711948154050294398450747240868797267146189908692675243187175727301621368593")
                        )
                    )
                    .insert(new PointCloseToEachOtherOutputDTO("1", "2", PreciseDecimal.from(10)))
                    .insert(new PointCloseToEachOtherOutputDTO("2", "3", PreciseDecimal.from(10)))
            ).toString()
        );
    }
}
