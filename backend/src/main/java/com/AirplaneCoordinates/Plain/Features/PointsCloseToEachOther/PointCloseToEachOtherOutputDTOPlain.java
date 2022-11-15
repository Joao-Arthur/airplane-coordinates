package com.AirplaneCoordinates.Plain.Features.PointsCloseToEachOther;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PointsCloseToEachOther.PointCloseToEachOtherOutputDTO;

public final class PointCloseToEachOtherOutputDTOPlain {
    public final String a;
    public final String b;
    public final String distance;

    public PointCloseToEachOtherOutputDTOPlain(
        final String a,
        final String b,
        final String distance
    ) {
        this.a = a;
        this.b = b;
        this.distance = distance;
    }

    public final PointCloseToEachOtherOutputDTO toObject() {
        return new PointCloseToEachOtherOutputDTO(
            this.a,
            this.b,
            PreciseDecimal.from(this.distance)
        );
    }

    public static final PointCloseToEachOtherOutputDTOPlain fromObject(final PointCloseToEachOtherOutputDTO dto) {
        return new PointCloseToEachOtherOutputDTOPlain(
            dto.a,
            dto.b,
            dto.distance.value
        );
    }
}
