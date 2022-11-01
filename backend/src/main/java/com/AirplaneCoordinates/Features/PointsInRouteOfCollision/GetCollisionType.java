package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.Plane.Generic.PlanePoint;
import com.AirplaneCoordinates.Core.Trigonometry.Trigonometry;
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
            Trigonometry.isInfiniteTangentAngle(Trigonometry.normalizeAngle(this.pointA.direction)) &&
            Trigonometry.isInfiniteTangentAngle(Trigonometry.normalizeAngle(this.pointB.direction))
        ) {
            if (this.pointA.point.toCartesian().x.equals(this.pointB.point.toCartesian().x))
                return CollisionType.INFINITE_TANGENT_SAME_X;
            return CollisionType.PARALLEL_LINES;
        }
        if (
            Trigonometry.isInfiniteTangentAngle(Trigonometry.normalizeAngle(this.pointA.direction)) ||
            Trigonometry.isInfiniteTangentAngle(Trigonometry.normalizeAngle(this.pointB.direction))
        )
            return CollisionType.INFINITE_TANGENT_IN_ONE_AIRPLANE;
    //    final var fx = linearFunction.fromPoint({ point: { x: a.x, y: a.y }, angle: a.direction });
    //    final var gx = linearFunction.fromPoint({ point: { x: b.x, y: b.y }, angle: b.direction });
    //    if (fx.a == gx.a && fx.b == gx.b)
    //        return CollisionType.SAME_FUNCTION;
    //    if (fx.a == gx.a)
    //        return CollisionType.PARALLEL_LINES;
        return CollisionType.DIFFERENT_FUNCTIONS;
    }
    
}
