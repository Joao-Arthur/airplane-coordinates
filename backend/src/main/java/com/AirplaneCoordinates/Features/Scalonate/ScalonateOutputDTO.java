package com.AirplaneCoordinates.Features.Scalonate;

import java.util.List;

import com.AirplaneCoordinates.Core.Serialization.Serializer;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class ScalonateOutputDTO {
    public final List<PlanePointWithId> points;

    public ScalonateOutputDTO(final List<PlanePointWithId> points) {
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
