package com.AirplaneCoordinates.Features.Scalonate;

import java.util.List;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.Serialization.Serializer;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class ScalonateInputDTO {
    public final List<PlanePointWithId> points;
    public final CartesianPoint factor;

    public ScalonateInputDTO(
        final List<PlanePointWithId> points,
        final CartesianPoint factor
    ) {
        this.points = points;
        this.factor = factor;
    }

    @Override
    public final String toString() {
        return "{\n" +
        "    points: [\n" +
        Serializer.serialize(this.points, 8) +
        "    ],\n" +
        "    factor: " + this.factor + "\n" +
        "}";
    }
}
