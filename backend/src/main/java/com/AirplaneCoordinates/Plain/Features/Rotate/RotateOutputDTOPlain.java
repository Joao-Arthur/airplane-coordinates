package com.AirplaneCoordinates.Plain.Features.Rotate;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Features.Rotate.RotateOutputDTO;
import com.AirplaneCoordinates.Plain.Features.DTO.PlanePointWithIdPlain;

public final class RotateOutputDTOPlain {
    public List<PlanePointWithIdPlain> points;

    public RotateOutputDTOPlain(final List<PlanePointWithIdPlain> points) {
        this.points = points;
    }

    public final RotateOutputDTO toObject() {
        return new RotateOutputDTO(
            this.points
                .stream()
                .map(point -> point.toObject())
                .collect(Collectors.toList())
        );
    }

    public static final RotateOutputDTOPlain fromObject(final RotateOutputDTO dto) {
        return new RotateOutputDTOPlain(
            dto.points
                .stream()
                .map(PlanePointWithIdPlain::fromObject)
                .collect(Collectors.toList())
        );
    }
}
