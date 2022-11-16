package com.AirplaneCoordinates.Features.Rotate;

import java.util.List;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.Serialization.Serializer;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;

public final class RotateInputDTO {
    public final List<PlanePointWithId> points;
    public final CartesianPoint centerOfRotation;
    public final PreciseDecimal angle;

    public RotateInputDTO(
        final List<PlanePointWithId> points,
        final CartesianPoint centerOfRotation,
        final PreciseDecimal angle
    ) {
        this.points = points;
        this.centerOfRotation = centerOfRotation;
        this.angle = angle;
    }

    @Override
    public final String toString() {
        return "{\n" +
        "    points: [\n" +
        Serializer.serialize(this.points, 8) +
        "    ],\n" +
        "    centerOfRotation: " + this.centerOfRotation + ",\n" +
        "    angle: " + this.angle + "\n" +
        "}";
    }
}
