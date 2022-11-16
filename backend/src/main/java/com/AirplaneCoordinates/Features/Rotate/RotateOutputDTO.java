package com.AirplaneCoordinates.Features.Rotate;

import java.util.List;

import com.AirplaneCoordinates.Core.Serialization.Serializer;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class RotateOutputDTO {
    public final List<PlanePointWithId> points;

    public RotateOutputDTO(final List<PlanePointWithId> points) {
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
