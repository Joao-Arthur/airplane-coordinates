package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

public final class ParallelLinesCollisionService implements CollisionPointService {
    private final PointDTO pointA;
    private final PointDTO pointB;
    
    public ParallelLinesCollisionService(
        final PointDTO pointA,
        final PointDTO pointB
    ) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public final CollisionDTO getCollisionPoint() {
        return null;
    }
}
