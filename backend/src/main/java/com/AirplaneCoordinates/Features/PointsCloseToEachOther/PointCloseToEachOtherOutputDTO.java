package com.AirplaneCoordinates.Features.PointsCloseToEachOther;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PointCloseToEachOtherOutputDTO {
    public final String a;
    public final String b;
    public final PreciseDecimal distance;

    public PointCloseToEachOtherOutputDTO(
        final String a,
        final String b,
        final PreciseDecimal distance
    ) {
        this.a = a;
        this.b = b;
        this.distance = distance;
    }

    @Override
    public final String toString() {
        return "{ " +
            "a: " + this.a + ", " +
            "b: " + this.b + ", " +
            "distance: " + this.distance +
        " }";
    }
}
