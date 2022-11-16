package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.LinearFunction.LinearFunction;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.Trigonometry.Deg;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithVector;

public final class DescribeFututePosition implements CollisionPointService {
    private final PlanePointWithVector pointA;
    private final PlanePointWithVector pointB;
    
    public DescribeFututePosition(
        final PlanePointWithVector pointA,
        final PlanePointWithVector pointB
    ) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public PointInRouteOfCollisionOutputDTO getCollisionPoint() {
        final var aSin = Deg.from(this.pointA.vector.direction).getCosValueInQuadrant(Deg.from(this.pointA.vector.direction).toRad().value.sin().abs());
        final var bSin = Deg.from(this.pointB.vector.direction).getCosValueInQuadrant(Deg.from(this.pointB.vector.direction).toRad().value.sin().abs());
        final var aCos = Deg.from(this.pointA.vector.direction).getSinValueInQuadrant(Deg.from(this.pointA.vector.direction).toRad().value.cos().abs());
        final var bCos = Deg.from(this.pointB.vector.direction).getSinValueInQuadrant(Deg.from(this.pointB.vector.direction).toRad().value.cos().abs());
        final var fxAX = LinearFunction.from(aSin.times(this.pointA.vector.speed), this.pointA.point.toCartesian().x);
        final var fxBX = LinearFunction.from(bSin.times(this.pointB.vector.speed), this.pointB.point.toCartesian().x);
        final var fxAY = LinearFunction.from(aCos.times(this.pointA.vector.speed), this.pointA.point.toCartesian().y);
        final var fxBY = LinearFunction.from(bCos.times(this.pointB.vector.speed), this.pointB.point.toCartesian().y);
        final var intersectionX = LinearFunction.intersectionPoint(fxAX, fxBX);
        if (intersectionX == null)
            return null;
        final var intersectionY = LinearFunction.intersectionPoint(fxAY, fxBY);
        if (intersectionY == null)
            return null;
        // até aqui tá garantido que tá certo

        System.out.println("intersectionX: " + intersectionX);
        System.out.println("intersectionY: " + intersectionY);
        System.out.println(" - - - - - - - - - - - - - - - - ");

        final var aXOnXIntersection = fxAX.execute(intersectionX.x);
        final var aYOnXIntersection = fxAY.execute(intersectionX.x);
        final var bXOnXIntersection = fxBX.execute(intersectionX.x);
        final var bYOnXIntersection = fxBY.execute(intersectionX.x);

        final var aOnXIntersection = CartesianPoint.from(aXOnXIntersection, aYOnXIntersection).round();
        final var bOnXIntersection = CartesianPoint.from(bXOnXIntersection, bYOnXIntersection).round();

        final var aXOnYIntersection = fxAX.execute(intersectionY.x);
        final var aYOnYIntersection = fxAY.execute(intersectionY.x);
        final var bXOnYIntersection = fxBX.execute(intersectionY.x);
        final var bYOnYIntersection = fxBY.execute(intersectionY.x);

        final var aOnYIntersection = CartesianPoint.from(aXOnYIntersection, aYOnYIntersection).round();
        final var bOnYIntersection = CartesianPoint.from(bXOnYIntersection, bYOnYIntersection).round();

        System.out.println("aOnXIntersection: " + aOnXIntersection);
        System.out.println("bOnXIntersection: " + bOnXIntersection);
        System.out.println(" - - - - - - - - - - - - - - - - ");
        System.out.println("aOnYIntersection: " + aOnYIntersection);
        System.out.println("bOnYIntersection: " + bOnYIntersection);
        System.out.println(" - - - - - - - - - - - - - - - - ");

        if (intersectionX.x.equals(intersectionY.x)) {
            System.out.println("X e Y são iguais ao mesmo tempos");
        } else {
            System.out.println("X e Y não são iguais ao mesmo tempo");
        }

        final var aX = fxAX.execute(intersectionX.y);
        final var aY = fxAY.execute(intersectionY.y);
        final var bX = fxBX.execute(intersectionX.y);
        final var bY = fxBY.execute(intersectionY.y);

        final var a = CartesianPoint.from(aX, aY);
        final var b = CartesianPoint.from(bX, bY);

        System.out.println("a: " + a.round().toString());
        System.out.println("b: " + b.round().toString());

        return new PointInRouteOfCollisionOutputDTOBuilder()
            .setA(this.pointA.id)
            .setB(this.pointB.id)
            .setTimeUntilCollision(PreciseDecimal.from(0))
            .setCollisionPoint(CartesianPoint.from(0, 0))
            .setTimeDifferenceToPoint(PreciseDecimal.from(0))
            .build();
    }
}
