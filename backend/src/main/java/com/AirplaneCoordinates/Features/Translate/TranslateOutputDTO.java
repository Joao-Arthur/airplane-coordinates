package com.AirplaneCoordinates.Features.Translate;

import java.util.List;

import com.AirplaneCoordinates.Core.Serialization.Serializer;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class TranslateOutputDTO {
    public final List<PlanePointWithId> points;

    public TranslateOutputDTO(final List<PlanePointWithId> points) {
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
