package com.AirplaneCoordinates.Features.PointsCloseToPoint;

import java.util.List;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.Serialization.Serializer;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class PointsCloseToPointInputDTO {
    public final List<PlanePointWithId> points;
    public final CartesianPoint point;
    public final PreciseDecimal maxDistance;

    public PointsCloseToPointInputDTO(
        final List<PlanePointWithId> points,
        final CartesianPoint point,
        final PreciseDecimal maxDistance
    ) {
        this.points = points;
        this.point = point;
        this.maxDistance = maxDistance;
    }

    @Override
    public final String toString() {
        return "{\n" +
        "    points: [\n" +
        Serializer.serialize(this.points, 8) +
        "    ],\n" +
        "    point: " + this.point + ",\n" +
        "    maxDistance: " + this.maxDistance + "\n" +
        "}";
    }
}
