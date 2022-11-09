package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.LinearFunction.LinearFunction;
import com.AirplaneCoordinates.Core.Trigonometry.Deg;
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
        final var cartesianA = this.pointA.point.toCartesian();
        final var cartesianB = this.pointB.point.toCartesian();
        if (
            cartesianA.x.equals(cartesianB.x) &&
            cartesianA.y.equals(cartesianB.y)
        )
            return CollisionType.SAME_POSITION;
        if (
            Deg.from(this.pointA.vector.direction).isInfiniteTangent() &&
            Deg.from(this.pointB.vector.direction).isInfiniteTangent()
        ) {
            if (cartesianA.x.equals(cartesianB.x))
                return CollisionType.INFINITE_TANGENT_SAME_X;
            return CollisionType.PARALLEL_LINES;
        }
        if (
            Deg.from(this.pointA.vector.direction).isInfiniteTangent() ||
            Deg.from(this.pointB.vector.direction).isInfiniteTangent()
        )
            return CollisionType.INFINITE_TANGENT_IN_ONE_POINT;
        final var fx = LinearFunction.from(
            cartesianA,
            this.pointA.vector.direction
        );
        final var gx = LinearFunction.from(
            cartesianB,
            this.pointB.vector.direction
        );
        if (fx.a.equals(gx.a) && fx.b.equals(gx.b))
            return CollisionType.SAME_FUNCTION;
        if (fx.a.equals(gx.a))
            return CollisionType.PARALLEL_LINES;
        return CollisionType.DIFFERENT_FUNCTIONS;
    }
}
