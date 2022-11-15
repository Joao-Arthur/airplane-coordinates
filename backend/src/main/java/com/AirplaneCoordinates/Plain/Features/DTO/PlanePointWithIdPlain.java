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

    public static final PlanePointWithIdPlain fromObject(final PlanePointWithId planePointWithId) {
        return new PlanePointWithIdPlain(
            planePointWithId.id,
            PlanePointPlain.fromObject(planePointWithId.point)
        );
    }
}
