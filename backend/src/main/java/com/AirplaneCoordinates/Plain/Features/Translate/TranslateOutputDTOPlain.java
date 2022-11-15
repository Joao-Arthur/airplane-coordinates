package com.AirplaneCoordinates.Plain.Features.Translate;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Features.Translate.TranslateOutputDTO;
import com.AirplaneCoordinates.Plain.Features.DTO.PlanePointWithIdPlain;

public final class TranslateOutputDTOPlain {
    public List<PlanePointWithIdPlain> points;

    public TranslateOutputDTOPlain(List<PlanePointWithIdPlain> points) {
        this.points = points;
    }

    public final TranslateOutputDTO toObject() {
        return new TranslateOutputDTO(
            this.points
                .stream()
                .map(point -> point.toObject())
                .collect(Collectors.toList())
        );
    }

    public static final TranslateOutputDTOPlain fromObject(final TranslateOutputDTO dto) {
        return new TranslateOutputDTOPlain(
            dto.points
                .stream()
                .map(PlanePointWithIdPlain::fromObject)
                .collect(Collectors.toList())
        );
    }
}
