package com.AirplaneCoordinates.Features.PointsCloseToEachOther;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PointsCloseToEachOtherOutputDTO {
    public final String a;
    public final String b;
    public final PreciseDecimal distanceFromPoint;

    public PointsCloseToEachOtherOutputDTO(
        final String a,
        final String b,
        final PreciseDecimal distanceFromPoint
    ) {
        this.a = a;
        this.b = b;
        this.distanceFromPoint = distanceFromPoint;
    }

    @Override
    public final String toString() {
        return "{ " +
            "a: " + this.a + ", " +
            "b: " + this.b + ", " +
            "distanceFromPoint: " + this.distanceFromPoint +
        " }";
    }
}
