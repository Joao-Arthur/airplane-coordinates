package com.AirplaneCoordinates.Plain.Features.DTO;

import com.AirplaneCoordinates.Features.DTO.PlanePointWithId;
import com.AirplaneCoordinates.Plain.Core.Plane.Generic.PlanePointPlain;

public final class PlanePointWithIdPlain {
    public final String id;
    public final PlanePointPlain point;

    public PlanePointWithIdPlain(
        final String id,
        final PlanePointPlain point
    ) {
        this.id = id;
        this.point = point;
    }

    public final PlanePointWithId toObject() {
        return new PlanePointWithId(this.id, this.point.toObject());
    }
}
