package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Features.PlanePointWithVector;

public final class SamePositionCollisionService implements CollisionPointService {
    private final PlanePointWithVector pointA;
    private final PlanePointWithVector pointB;
    
    public SamePositionCollisionService(
        final PlanePointWithVector pointA,
        final PlanePointWithVector pointB
    ) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public final CollisionDTO getCollisionPoint() {
        return new CollisionDTOBuilder()
            .setA(this.pointA.id)
            .setB(this.pointB.id)
            .setTimeUntilCollision(PreciseDecimal.from(0))
            .setCollisionPoint(this.pointA.point.toCartesian())
            .setTimeDifferenceToPoint(PreciseDecimal.from(0))
            .build();
    }
}
