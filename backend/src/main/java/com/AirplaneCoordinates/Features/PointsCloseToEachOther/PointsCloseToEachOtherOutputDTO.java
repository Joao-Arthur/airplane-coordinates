package com.AirplaneCoordinates.Features.PointsCloseToEachOther;

import java.util.List;

import com.AirplaneCoordinates.Core.Serialization.Serializer;

public final class PointsCloseToEachOtherOutputDTO {
    public final List<PointCloseToEachOtherOutputDTO> points;

    public PointsCloseToEachOtherOutputDTO(
        final List<PointCloseToEachOtherOutputDTO> points
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
