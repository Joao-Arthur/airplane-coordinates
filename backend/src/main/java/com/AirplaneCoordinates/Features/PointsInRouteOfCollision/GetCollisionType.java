package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.LinearFunction.LinearFunction;
import com.AirplaneCoordinates.Core.Trigonometry.Degree;
import com.AirplaneCoordinates.Features.PlanePointWithVector;

public final class GetCollisionType {
    private final PlanePointWithVector pointA;
    private final PlanePointWithVector pointB;
    
    public GetCollisionType(
        final PlanePointWithVector pointA,
        final PlanePointWithVector pointB
    ) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public final CollisionType getCollisionType() {
        if (
            this.pointA.point.a.equals(this.pointA.point.a) &&
            this.pointB.point.b.equals(this.pointB.point.b)
        )
            return CollisionType.SAME_POSITION;
        if (
            Degree.from(this.pointA.vector.direction).isInfiniteTangent() &&
            Degree.from(this.pointB.vector.direction).isInfiniteTangent()
        ) {
            if (this.pointA.point.toCartesian().x.equals(this.pointB.point.toCartesian().x))
                return CollisionType.INFINITE_TANGENT_SAME_X;
            return CollisionType.PARALLEL_LINES;
        }
        if (
            Degree.from(this.pointA.vector.direction).isInfiniteTangent() ||
            Degree.from(this.pointB.vector.direction).isInfiniteTangent()
        )
            return CollisionType.INFINITE_TANGENT_IN_ONE_AIRPLANE;
        final var fx = LinearFunction.from(
            this.pointA.point.toCartesian(),
            this.pointA.vector.direction
        );
        final var gx = LinearFunction.from(
            this.pointB.point.toCartesian(),
            this.pointB.vector.direction
        );
        if (fx.a.equals(gx.a) && fx.b.equals(gx.b))
            return CollisionType.SAME_FUNCTION;
        if (fx.a.equals(gx.a))
            return CollisionType.PARALLEL_LINES;
        return CollisionType.DIFFERENT_FUNCTIONS;
    }
}
