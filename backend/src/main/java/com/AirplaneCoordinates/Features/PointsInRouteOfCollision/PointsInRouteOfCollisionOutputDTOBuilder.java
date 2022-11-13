package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class PointsInRouteOfCollisionOutputDTOBuilder {
    public String a;
    public String b;
    public PreciseDecimal timeUntilCollision;
    public CartesianPoint collisionPoint;
    public PreciseDecimal timeDifferenceToPoint;

    public final PointsInRouteOfCollisionOutputDTOBuilder setA(final String a) {
        this.a = a;
        return this;
    }

    public final PointsInRouteOfCollisionOutputDTOBuilder setB(final String b) {
        this.b = b;
        return this;
    }

    public final PointsInRouteOfCollisionOutputDTOBuilder setTimeUntilCollision(final PreciseDecimal timeUntilCollision) {
        this.timeUntilCollision = timeUntilCollision;
        return this;
    }

    public final PointsInRouteOfCollisionOutputDTOBuilder setCollisionPoint(final CartesianPoint collisionPoint) {
        this.collisionPoint = collisionPoint;
        return this;
    }

    public final PointsInRouteOfCollisionOutputDTOBuilder setTimeDifferenceToPoint(final PreciseDecimal timeDifferenceToPoint) {
        this.timeDifferenceToPoint = timeDifferenceToPoint;
        return this;
    }

    public final PointsInRouteOfCollisionOutputDTO build() {
        return new PointsInRouteOfCollisionOutputDTO(
            this.a,
            this.b,
            this.timeUntilCollision,
            this.collisionPoint,
            this.timeDifferenceToPoint
        );
    }
}
