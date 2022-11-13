package com.AirplaneCoordinates.Features.PointsCloseToEachOther;

import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class PointCombination {
    public final PlanePointWithId a;
    public final PlanePointWithId b;

    public PointCombination(
        final PlanePointWithId a,
        final PlanePointWithId b
    ) {
        this.a = a;
        this.b = b;
    }
}
