package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import java.util.List;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.Serialization.Serializer;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithVector;

public final class PointsInRouteOfCollisionInputDTO {
    public final List<PlanePointWithVector> points;
    public final PreciseDecimal maxTime;

    public PointsInRouteOfCollisionInputDTO(
        final List<PlanePointWithVector> points,
        final PreciseDecimal maxTime
    ) {
        this.points = points;
    }

    @Override
    public final String toString() {
        return "{" + "\n" +
        "    points: [" + "\n" +
        Serializer.serialize(this.points, 8) +
        "    ]," + "\n" +
        "    maxTime: " + this.maxTime + "\n" +
        "}";
    }
}
