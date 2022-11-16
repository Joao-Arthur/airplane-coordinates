package com.AirplaneCoordinates.Plain.Features.Scalonate;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Features.Scalonate.ScalonateOutputDTO;
import com.AirplaneCoordinates.Plain.Features.DTO.PlanePointWithIdPlain;

public final class ScalonateOutputDTOPlain {
    public List<PlanePointWithIdPlain> points;

    public ScalonateOutputDTOPlain(final List<PlanePointWithIdPlain> points) {
        this.points = points;
    }

    public final ScalonateOutputDTO toObject() {
        return new ScalonateOutputDTO(
            this.points
                .stream()
                .map(point -> point.toObject())
                .collect(Collectors.toList())
        );
    }

    public static final ScalonateOutputDTOPlain fromObject(final ScalonateOutputDTO dto) {
        return new ScalonateOutputDTOPlain(
            dto.points
                .stream()
                .map(PlanePointWithIdPlain::fromObject)
                .collect(Collectors.toList())
        );
    }
}
