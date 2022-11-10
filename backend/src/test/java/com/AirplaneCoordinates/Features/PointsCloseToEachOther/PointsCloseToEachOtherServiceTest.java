package com.AirplaneCoordinates.Features.PointsCloseToEachOther;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PlanePointWithId;

public final class PointsCloseToEachOtherServiceTest {
    @Test
    public final void pointsCloseToPoint() {
        final var points = new ArrayList<PlanePointWithId>();
        points.add(PlanePointWithId.from("1", PlanePoint.from(Plane.CARTESIAN, 10, 10)));
        points.add(PlanePointWithId.from("2", PlanePoint.from(Plane.CARTESIAN, 10, 20)));
        points.add(PlanePointWithId.from("3", PlanePoint.from(Plane.CARTESIAN, 0, 20)));
        points.add(PlanePointWithId.from("4", PlanePoint.from(Plane.CARTESIAN, 2, 22)));

        final var actual = new PointsCloseToEachOtherService(points, PreciseDecimal.from(10)).execute();

        final var expected = new ArrayList<PointCloseToEachOtherDTO>();
        expected.add(PointCloseToEachOtherDTO.from("3", "4", PreciseDecimal.from("2.828427124746190097603377448419396157139343750753896146353359475981464956924214077700775068655283145")));
        expected.add(PointCloseToEachOtherDTO.from("2", "4", PreciseDecimal.from("8.246211251235321099642819711948154050294398450747240868797267146189908692675243187175727301621368593")));
        expected.add(PointCloseToEachOtherDTO.from("1", "2", PreciseDecimal.from(10)));
        expected.add(PointCloseToEachOtherDTO.from("2", "3", PreciseDecimal.from(10)));

        assertEquals(
            Arrays.toString(actual.toArray()),
            Arrays.toString(expected.toArray())
        );
    }
}
