package com.AirplaneCoordinates.Plain.Core.Plane.Generic;

import com.AirplaneCoordinates.Core.Plane.Generic.Plane;
import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;

public final class PlanePointPlain {
    public final Plane planeType;
    public final String a;
    public final String b;

    public PlanePointPlain(
        final Plane planeType,
        final String a,
        final String b
    ) {
        this.planeType = planeType;
        this.a = a;
        this.b = b;
    }

    public final PlanePoint toObject() {
        return PlanePoint.from(
            this.planeType,
            this.a,
            this.b
        );
    }

    public static final PlanePointPlain fromObject(final PlanePoint planePoint) {
        return new PlanePointPlain(
            planePoint.planeType,
            planePoint.a.value,
            planePoint.b.value
        );
    }
}
