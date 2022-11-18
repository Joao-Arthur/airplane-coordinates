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
        // SamePosition - OK
        // SameFunction - null cases
        // Infinite tangent in one point - same speed
        // Different function - same speed

        final var coefficientAX = Deg.from(this.pointA.vector.direction).getCosValueInQuadrant(Deg.from(this.pointA.vector.direction).toRad().value.cos().abs());
        final var coefficientBX = Deg.from(this.pointB.vector.direction).getCosValueInQuadrant(Deg.from(this.pointB.vector.direction).toRad().value.cos().abs());
        final var coefficientAY = Deg.from(this.pointA.vector.direction).getSinValueInQuadrant(Deg.from(this.pointA.vector.direction).toRad().value.sin().abs());
        final var coefficientBY = Deg.from(this.pointB.vector.direction).getSinValueInQuadrant(Deg.from(this.pointB.vector.direction).toRad().value.sin().abs());
        final var fxAX = LinearFunction.from(coefficientAX.times(this.pointA.vector.speed), this.pointA.point.toCartesian().x);
        final var fxBX = LinearFunction.from(coefficientBX.times(this.pointB.vector.speed), this.pointB.point.toCartesian().x);
        final var fxAY = LinearFunction.from(coefficientAY.times(this.pointA.vector.speed), this.pointA.point.toCartesian().y);
        final var fxBY = LinearFunction.from(coefficientBY.times(this.pointB.vector.speed), this.pointB.point.toCartesian().y);

        final var intersectionX = LinearFunction.intersectionPoint(fxAX, fxBX);
        final var intersectionY = LinearFunction.intersectionPoint(fxAY, fxBY);

        if (intersectionX != null) {
            final var aXOnXIntersection = fxAX.execute(intersectionX.x);
            final var aYOnXIntersection = fxAY.execute(intersectionX.x);
            final var bXOnXIntersection = fxBX.execute(intersectionX.x);
            final var bYOnXIntersection = fxBY.execute(intersectionX.x);

            if(
                aXOnXIntersection.roundedValue().equals(bXOnXIntersection.roundedValue()) &&
                aYOnXIntersection.roundedValue().equals(bYOnXIntersection.roundedValue())
            ) {
                return new PointInRouteOfCollisionOutputDTOBuilder()
                    .setA(this.pointA.id)
                    .setB(this.pointB.id)
                    .setTimeUntilCollision(intersectionX.x.round())
                    .setCollisionPoint(CartesianPoint.from(aXOnXIntersection, aYOnXIntersection).round())
                    .setTimeDifferenceToPoint(PreciseDecimal.from(0))
                    .build();
            }
        }

        //when all tests are passing, verify if this step can be removed 
        if (intersectionY != null) {
            final var aXOnYIntersection = fxAX.execute(intersectionY.x);
            final var aYOnYIntersection = fxAY.execute(intersectionY.x);
            final var bXOnYIntersection = fxBX.execute(intersectionY.x);
            final var bYOnYIntersection = fxBY.execute(intersectionY.x);

            if(
                aXOnYIntersection.roundedValue().equals(bXOnYIntersection.roundedValue()) &&
                aYOnYIntersection.roundedValue().equals(bYOnYIntersection.roundedValue())
            ) {
                return new PointInRouteOfCollisionOutputDTOBuilder()
                    .setA(this.pointA.id)
                    .setB(this.pointB.id)
                    .setTimeUntilCollision(intersectionY.x.round())
                    .setCollisionPoint(CartesianPoint.from(aXOnYIntersection, aYOnYIntersection).round())
                    .setTimeDifferenceToPoint(PreciseDecimal.from(0))
                    .build();
            }
        }

        final var fxAXWithoutSpeed = LinearFunction.from(coefficientAX, this.pointA.point.toCartesian().x);
        final var fxBXWithoutSpeed = LinearFunction.from(coefficientBX, this.pointB.point.toCartesian().x);
        final var fxAYWithoutSpeed = LinearFunction.from(coefficientAY, this.pointA.point.toCartesian().y);
        final var fxBYWithoutSpeed = LinearFunction.from(coefficientBY, this.pointB.point.toCartesian().y);

        final var intersectionXWithoutSpeed = LinearFunction.intersectionPoint(fxAXWithoutSpeed, fxBXWithoutSpeed);
        final var intersectionYWithoutSpeed = LinearFunction.intersectionPoint(fxAYWithoutSpeed, fxBYWithoutSpeed);

        if (intersectionXWithoutSpeed != null) {

            final var aXOnXTimeUntilIntersection = intersectionXWithoutSpeed.x.divide(this.pointA.vector.speed);
            final var bXOnXTimeUntilIntersection = intersectionXWithoutSpeed.x.divide(this.pointB.vector.speed);
            final var aYOnXTimeUntilIntersection = intersectionXWithoutSpeed.x.divide(this.pointA.vector.speed);
            final var bYOnXTimeUntilIntersection = intersectionXWithoutSpeed.x.divide(this.pointB.vector.speed);

            System.out.println("aXOnXTimeUntilIntersection:" + aXOnXTimeUntilIntersection.round());
            System.out.println("aYOnXTimeUntilIntersection:" + aYOnXTimeUntilIntersection.round());
            System.out.println("bXOnXTimeUntilIntersection:" + bXOnXTimeUntilIntersection.round());
            System.out.println("bYOnXTimeUntilIntersection:" + bYOnXTimeUntilIntersection.round());
            //em teoria até aqui está ok

            final var timeUntilCollision = PreciseDecimal.min(
                aXOnXTimeUntilIntersection,
                bXOnXTimeUntilIntersection
            );
            final var timeDifferenceToPoint = aXOnXTimeUntilIntersection.minus(bXOnXTimeUntilIntersection).abs();

            final var aXOnXIntersection = fxAXWithoutSpeed.execute(intersectionXWithoutSpeed.x);
            final var aYOnXIntersection = fxAYWithoutSpeed.execute(intersectionXWithoutSpeed.x);

            return new PointInRouteOfCollisionOutputDTOBuilder()
                .setA(this.pointA.id)
                .setB(this.pointB.id)
                .setTimeUntilCollision(timeUntilCollision.round())
                .setCollisionPoint(CartesianPoint.from(aXOnXIntersection, aYOnXIntersection).round())
                .setTimeDifferenceToPoint(timeDifferenceToPoint)
                .build();
        }

        return null;
    }
}
