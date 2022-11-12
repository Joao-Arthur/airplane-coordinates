package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

public final class CollisionPointServiceFactory {
    private final PointDTO pointA;
    private final PointDTO pointB;
    
    public CollisionPointServiceFactory(
        final PointDTO pointA,
        final PointDTO pointB
    ) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public final CollisionPointService getService() {
        switch (new GetCollisionType(this.pointA, this.pointB).getCollisionType()) {
            case SAME_POSITION: 
                return new SamePositionCollisionService(this.pointA, this.pointB);
            case INFINITE_TANGENT_SAME_X:
                return new InfiniteTangentSameXCollisionService(this.pointA, this.pointB);
            case PARALLEL_LINES:
                return new ParallelLinesCollisionService(this.pointA, this.pointB);
            case INFINITE_TANGENT_IN_ONE_POINT:
                return new InfiniteTangentInOnePointCollisionService(this.pointA, this.pointB);
            case SAME_FUNCTION:
                return new SameFunctionCollisionService(this.pointA, this.pointB);
            case DIFFERENT_FUNCTIONS:
                return new DifferentFunctionsCollisionService(this.pointA, this.pointB);
            default:
                throw new RuntimeException("invalid CollisionType");
        }
    }
}