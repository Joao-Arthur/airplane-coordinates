package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PointsCollisionDTO {
    public final String a;
    public final String b;
    public final PreciseDecimal timeUntilCollision;
    public final CartesianPoint collisionPoint;
    public final PreciseDecimal timeDifferenceToPoint;

    public PointsCollisionDTO(
        final String a,
        final String b,
        final PreciseDecimal timeUntilCollision,
        final CartesianPoint collisionPoint,
        final PreciseDecimal timeDifferenceToPoint
    ) {
        this.a = a;
        this.b = b;
        this.timeUntilCollision = timeUntilCollision;
        this.collisionPoint = collisionPoint;
        this.timeDifferenceToPoint = timeDifferenceToPoint;
    }
}
