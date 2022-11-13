package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PointInRouteOfCollisionOutputDTOBuilder {
    public String a;
    public String b;
    public PreciseDecimal timeUntilCollision;
    public CartesianPoint collisionPoint;
    public PreciseDecimal timeDifferenceToPoint;

    public final PointInRouteOfCollisionOutputDTOBuilder setA(final String a) {
        this.a = a;
        return this;
    }

    public final PointInRouteOfCollisionOutputDTOBuilder setB(final String b) {
        this.b = b;
        return this;
    }

    public final PointInRouteOfCollisionOutputDTOBuilder setTimeUntilCollision(final PreciseDecimal timeUntilCollision) {
        this.timeUntilCollision = timeUntilCollision;
        return this;
    }

    public final PointInRouteOfCollisionOutputDTOBuilder setCollisionPoint(final CartesianPoint collisionPoint) {
        this.collisionPoint = collisionPoint;
        return this;
    }

    public final PointInRouteOfCollisionOutputDTOBuilder setTimeDifferenceToPoint(final PreciseDecimal timeDifferenceToPoint) {
        this.timeDifferenceToPoint = timeDifferenceToPoint;
        return this;
    }

    public final PointInRouteOfCollisionOutputDTO build() {
        return new PointInRouteOfCollisionOutputDTO(
            this.a,
            this.b,
            this.timeUntilCollision,
            this.collisionPoint,
            this.timeDifferenceToPoint
        );
    }
}
