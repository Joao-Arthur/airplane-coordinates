package com.AirplaneCoordinates.Plain.Features.Rotate;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.Rotate.RotateInputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Cartesian.CartesianPointPlain;
import com.AirplaneCoordinates.Plain.Features.DTO.PlanePointWithIdPlain;

public final class RotateInputDTOPlain {
    public final List<PlanePointWithIdPlain> points;
    public final CartesianPointPlain centerOfRotation;
    public final String angle;

    public RotateInputDTOPlain(
        final List<PlanePointWithIdPlain> points,
        final CartesianPointPlain centerOfRotation,
        final String angle
    ) {
        this.points = points;
        this.centerOfRotation = centerOfRotation;
        this.angle = angle;
    }

    public final RotateInputDTO toObject() {
        return new RotateInputDTO(
            this.points
                .stream()
                .map(point -> point.toObject())
                .collect(Collectors.toList()),
            this.centerOfRotation.toObject(),
            PreciseDecimal.from(this.angle)
        );
    }  
}
