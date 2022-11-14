package com.AirplaneCoordinates.Features.PointsCloseToEachOther;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class PointsCloseToEachOtherServiceTest {
    @Test
    public final void pointsCloseToPoint() {
        final var points = new ArrayList<PlanePointWithId>();
        points.add(new PlanePointWithId("1", PlanePoint.from(Plane.CARTESIAN, 10, 10)));
        points.add(new PlanePointWithId("2", PlanePoint.from(Plane.CARTESIAN, 10, 20)));
        points.add(new PlanePointWithId("3", PlanePoint.from(Plane.CARTESIAN, 0, 20)));
        points.add(new PlanePointWithId("4", PlanePoint.from(Plane.CARTESIAN, 2, 22)));

        final var actual = new PointsCloseToEachOtherService(
            new PointsCloseToEachOtherInputDTO(points, PreciseDecimal.from(10))
        ).execute();

        final var expectedItems = new ArrayList<PointCloseToEachOtherOutputDTO>();
        expectedItems.add(new PointCloseToEachOtherOutputDTO("3", "4", PreciseDecimal.from("2.828427124746190097603377448419396157139343750753896146353359475981464956924214077700775068655283145")));
        expectedItems.add(new PointCloseToEachOtherOutputDTO("2", "4", PreciseDecimal.from("8.246211251235321099642819711948154050294398450747240868797267146189908692675243187175727301621368593")));
        expectedItems.add(new PointCloseToEachOtherOutputDTO("1", "2", PreciseDecimal.from(10)));
        expectedItems.add(new PointCloseToEachOtherOutputDTO("2", "3", PreciseDecimal.from(10)));

        final var expected = new PointsCloseToEachOtherOutputDTO(expectedItems);

        assertEquals(
            actual.toString(),
            expected.toString()
        );
    }
}
