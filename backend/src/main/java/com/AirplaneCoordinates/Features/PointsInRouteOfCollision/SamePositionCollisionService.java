package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;

public final class SamePositionCollisionService implements CollisionPointService {
    private final PointDTO pointA;
    private final PointDTO pointB;
    
    public SamePositionCollisionService(
        final PointDTO pointA,
        final PointDTO pointB
    ) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public final CollisionDTO getCollisionPoint() {
        return new CollisionDTOBuilder()
            .setA(this.pointA.planePoint.id)
            .setB(this.pointB.planePoint.id)
            .setTimeUntilCollision(PreciseDecimal.from(0))
            .setCollisionPoint(this.pointA.asCartesian)
            .setTimeDifferenceToPoint(PreciseDecimal.from(0))
            .build();
    }
}
