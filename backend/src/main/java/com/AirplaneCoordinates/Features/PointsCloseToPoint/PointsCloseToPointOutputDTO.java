package com.AirplaneCoordinates.Features.PointsCloseToPoint;

import java.util.List;

import com.AirplaneCoordinates.Core.Serialization.Serializer;

public class PointsCloseToPointOutputDTO {
    public final List<PointCloseToPointOutputDTO> points;

    public PointsCloseToPointOutputDTO(
        final List<PointCloseToPointOutputDTO> points
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
