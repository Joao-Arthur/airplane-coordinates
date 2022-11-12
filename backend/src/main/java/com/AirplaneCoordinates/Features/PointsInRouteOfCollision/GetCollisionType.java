package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

public final class GetCollisionType {
    private final PointDTO pointA;
    private final PointDTO pointB;
    
    public GetCollisionType(
        final PointDTO pointA,
        final PointDTO pointB
    ) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public final CollisionType getCollisionType() {
        final var isXEquals = this.pointA.asCartesian.x.equals(this.pointB.asCartesian.x);
        final var isYEquals = this.pointA.asCartesian.y.equals(this.pointB.asCartesian.y);
        final var isAEquals = this.pointA.fx.a.equals(this.pointB.fx.a);
        final var isBEquals = this.pointA.fx.b.equals(this.pointB.fx.b);

        if (isXEquals && isYEquals)
            return CollisionType.SAME_POSITION;
        if (this.pointA.isInfiniteTangent && this.pointB.isInfiniteTangent && isXEquals)
            return CollisionType.INFINITE_TANGENT_SAME_X;
        if (this.pointA.isInfiniteTangent && this.pointB.isInfiniteTangent)
            return CollisionType.PARALLEL_LINES;
        if (this.pointA.isInfiniteTangent || this.pointB.isInfiniteTangent)
            return CollisionType.INFINITE_TANGENT_IN_ONE_POINT;
        if (isAEquals && isBEquals)
            return CollisionType.SAME_FUNCTION;
        if (isAEquals)
            return CollisionType.PARALLEL_LINES;
        return CollisionType.DIFFERENT_FUNCTIONS;
    }
}
