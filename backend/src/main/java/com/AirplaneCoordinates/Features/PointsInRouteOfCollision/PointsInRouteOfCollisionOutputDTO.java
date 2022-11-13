package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import java.util.List;

import com.AirplaneCoordinates.Core.Serialization.Serializer;

public final class PointsInRouteOfCollisionOutputDTO {
    public final List<PointInRouteOfCollisionOutputDTO> points;

    public PointsInRouteOfCollisionOutputDTO(
        final List<PointInRouteOfCollisionOutputDTO> points
    ) {
        this.points = points;
    }

    @Override
    public final String toString() {
        return "{\n" +
        "    points: [\n" +
        Serializer.serialize(this.points, 8) +
        "    ]\n" +
        "}";
    }
}
