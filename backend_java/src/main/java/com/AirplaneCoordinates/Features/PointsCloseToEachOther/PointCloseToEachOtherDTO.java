package com.AirplaneCoordinates.Features.PointsCloseToEachOther;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PointCloseToEachOtherDTO {
    public final String a;
    public final String b;
    public final PreciseDecimal distanceFromPoint;

    private PointCloseToEachOtherDTO(
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
        return "{ a: " + a + ", b: " + b + ", distanceFromPoint: " + distanceFromPoint + " }";
    }

    public static final PointCloseToEachOtherDTO from(
        final String a,
        final String b,
        final PreciseDecimal distanceFromPoint
    ) {
        return new PointCloseToEachOtherDTO(
            a,
            b,
            distanceFromPoint
        );
    }

    public static final PointCloseToEachOtherDTO from(
        final String a,
        final String b,
        final String distanceFromPoint
    ) {
        return new PointCloseToEachOtherDTO(
            a,
            b,
            PreciseDecimal.from(distanceFromPoint)
        );
    }

    public static final PointCloseToEachOtherDTO from(
        final String a,
        final String b,
        final int distanceFromPoint
    ) {
        return new PointCloseToEachOtherDTO(
            a,
            b,
            PreciseDecimal.from(distanceFromPoint)
        );
    }
}
