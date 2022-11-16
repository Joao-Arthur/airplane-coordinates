package com.AirplaneCoordinates.Plain.Features.Scalonate;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Features.Scalonate.ScalonateInputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Cartesian.CartesianPointPlain;
import com.AirplaneCoordinates.Plain.Features.DTO.PlanePointWithIdPlain;

public final class ScalonateInputDTOPlain {
    public final List<PlanePointWithIdPlain> points;
    public final CartesianPointPlain factor;

    public ScalonateInputDTOPlain(
        final List<PlanePointWithIdPlain> points,
        final CartesianPointPlain factor
    ) {
        this.points = points;
        this.factor = factor;
    }

    public final ScalonateInputDTO toObject() {
        return new ScalonateInputDTO(
            this.points
                .stream()
                .map(point -> point.toObject())
                .collect(Collectors.toList()),
            this.factor.toObject()
        );
    }   
}
