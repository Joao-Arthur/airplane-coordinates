package com.AirplaneCoordinates.Plain.Features.PointsCloseToPoint;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PointsCloseToPoint.PointCloseToPointOutputDTO;

public final class PointCloseToPointOutputDTOPlain {
    public final String id;
    public final String distanceFromPoint;

    public PointCloseToPointOutputDTOPlain(
        final String id,
        final String distanceFromPoint
    ) {
        this.id = id;
        this.distanceFromPoint = distanceFromPoint;
    }

    public final PointCloseToPointOutputDTO toObject() {
        return new PointCloseToPointOutputDTO(
            this.id,
            PreciseDecimal.from(this.distanceFromPoint)
        );
    }

    public static final PointCloseToPointOutputDTOPlain fromObject(final PointCloseToPointOutputDTO dto) {
        return new PointCloseToPointOutputDTOPlain(
            dto.id,
            dto.distanceFromPoint.value
        );
    }
}
