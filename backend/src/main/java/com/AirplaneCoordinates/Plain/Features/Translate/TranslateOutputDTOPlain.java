package com.AirplaneCoordinates.Plain.Features.Translate;

import com.AirplaneCoordinates.Features.Translate.TranslateOutputDTO;
import com.AirplaneCoordinates.Plain.Core.Plane.Generic.PlanePointPlain;

public final class TranslateOutputDTOPlain {
    public final PlanePointPlain point;

    public TranslateOutputDTOPlain(final PlanePointPlain point) {
        this.point = point;
    }

    public final TranslateOutputDTO toObject() {
        return new TranslateOutputDTO(
            this.point.toObject()
        );
    }

    public static final TranslateOutputDTOPlain fromObject(final TranslateOutputDTO dto) {
        return new TranslateOutputDTOPlain(
            PlanePointPlain.fromObject(dto.point)
        );
    }
}
