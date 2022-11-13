package com.AirplaneCoordinates.Features.PointsCloseToEachOther;

import java.util.List;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.Serialization.Serializer;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class PointsCloseToEachOtherInputDTO {
    public final List<PlanePointWithId> points;
    public final PreciseDecimal maxDistance;

    public PointsCloseToEachOtherInputDTO(
        final List<PlanePointWithId> points,
        final PreciseDecimal maxDistance
    ) {
        this.points = points;
        this.maxDistance = maxDistance;
    }

    @Override
    public final String toString() {
        return "{\n" +
        "    points: [\n" +
        Serializer.serialize(this.points, 8) +
        "    ],\n" +
        "    maxDistance: " + this.maxDistance + "\n" +
        "}";
    }
}
