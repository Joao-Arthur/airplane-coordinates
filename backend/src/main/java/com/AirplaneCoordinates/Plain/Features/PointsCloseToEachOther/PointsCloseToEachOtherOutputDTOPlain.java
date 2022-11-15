package com.AirplaneCoordinates.Plain.Features.PointsCloseToEachOther;

import java.util.List;
import java.util.stream.Collectors;

import com.AirplaneCoordinates.Features.PointsCloseToEachOther.PointsCloseToEachOtherOutputDTO;

public final class PointsCloseToEachOtherOutputDTOPlain {
    public final List<PointCloseToEachOtherOutputDTOPlain> points;

    public PointsCloseToEachOtherOutputDTOPlain(
        List<PointCloseToEachOtherOutputDTOPlain> points
    ) {
        this.points = points;
    }

    public final PointsCloseToEachOtherOutputDTO toObject() {
        return new PointsCloseToEachOtherOutputDTO(
            this.points
                .stream()
                .map(point -> point.toObject())
                .collect(Collectors.toList())
        );
    }

    public static final PointsCloseToEachOtherOutputDTOPlain fromObject(final PointsCloseToEachOtherOutputDTO dto) {
        return new PointsCloseToEachOtherOutputDTOPlain(
            dto.points
                .stream()
                .map(point -> PointCloseToEachOtherOutputDTOPlain.fromObject(point))
                .collect(Collectors.toList())
        );
    }
}
