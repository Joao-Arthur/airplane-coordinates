package com.AirplaneCoordinates.Plain.Features.Translate;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Features.Translate.TranslateInputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Cartesian.CartesianPointPlain;
import com.AirplaneCoordinates.Plain.Features.DTO.PlanePointWithIdPlain;

public final class TranslateInputDTOPlain {
    public final List<PlanePointWithIdPlain> points;
    public final CartesianPointPlain factor;

    public TranslateInputDTOPlain(
        final List<PlanePointWithIdPlain> points,
        final CartesianPointPlain factor
    ) {
        this.points = points;
        this.factor = factor;
    }

    public final TranslateInputDTO toObject() {
        return new TranslateInputDTO(
            this.points
                .stream()
                .map(point -> point.toObject())
                .collect(Collectors.toList()),
            this.factor.toObject()
        );
    }   
}
