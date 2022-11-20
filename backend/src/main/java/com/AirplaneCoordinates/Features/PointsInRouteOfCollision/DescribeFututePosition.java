package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Core.LinearFunction.LinearFunction;
import com.AirplaneCoordinates.Core.Plane.Cartesian.CartesianPoint;
import com.AirplaneCoordinates.Core.PreciseDecimal.PreciseDecimal;
import com.AirplaneCoordinates.Core.Trigonometry.Deg;
import com.AirplaneCoordinates.Features.DTO.PlanePointWithVector;

public final class DescribeFututePosition {
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
            final var aXOnXIntersection = fxAX.execute(intersectionX);
            final var aYOnXIntersection = fxAY.execute(intersectionX);
            final var bXOnXIntersection = fxBX.execute(intersectionX);
            final var bYOnXIntersection = fxBY.execute(intersectionX);

            if (
                aXOnXIntersection.roundedValue().equals(bXOnXIntersection.roundedValue()) &&
                aYOnXIntersection.roundedValue().equals(bYOnXIntersection.roundedValue())
            )
                return new PointInRouteOfCollisionOutputDTOBuilder()
                    .setA(this.pointA.id)
                    .setB(this.pointB.id)
                    .setTimeUntilCollision(intersectionX.round())
                    .setCollisionPoint(CartesianPoint.from(aXOnXIntersection, aYOnXIntersection).round())
                    .setTimeDifferenceToPoint(PreciseDecimal.from(0))
                    .build();
        }

        //when all tests are passing, verify if this step can be removed 
        if (intersectionY != null) {
            final var aXOnYIntersection = fxAX.execute(intersectionY);
            final var aYOnYIntersection = fxAY.execute(intersectionY);
            final var bXOnYIntersection = fxBX.execute(intersectionY);
            final var bYOnYIntersection = fxBY.execute(intersectionY);

            if (
                aXOnYIntersection.roundedValue().equals(bXOnYIntersection.roundedValue()) &&
                aYOnYIntersection.roundedValue().equals(bYOnYIntersection.roundedValue())
            )
                return new PointInRouteOfCollisionOutputDTOBuilder()
                    .setA(this.pointA.id)
                    .setB(this.pointB.id)
                    .setTimeUntilCollision(intersectionY.round())
                    .setCollisionPoint(CartesianPoint.from(aXOnYIntersection, aYOnYIntersection).round())
                    .setTimeDifferenceToPoint(PreciseDecimal.from(0))
                    .build();
        }

        final var fxAXWithoutSpeed = LinearFunction.from(coefficientAX, this.pointA.point.toCartesian().x);
        final var fxBXWithoutSpeed = LinearFunction.from(coefficientBX, this.pointB.point.toCartesian().x);
        final var fxAYWithoutSpeed = LinearFunction.from(coefficientAY, this.pointA.point.toCartesian().y);
        final var fxBYWithoutSpeed = LinearFunction.from(coefficientBY, this.pointB.point.toCartesian().y);

        final var intersectionXWithoutSpeed = LinearFunction.intersectionPoint(fxAXWithoutSpeed, fxBXWithoutSpeed);
        final var intersectionYWithoutSpeed = LinearFunction.intersectionPoint(fxAYWithoutSpeed, fxBYWithoutSpeed);

        if (intersectionXWithoutSpeed != null && intersectionYWithoutSpeed != null) {
            final var aXOnXIntersectionWithoutSpeed = fxAXWithoutSpeed.execute(intersectionXWithoutSpeed);
            final var bXOnYIntersectionWithoutSpeed = fxBXWithoutSpeed.execute(intersectionXWithoutSpeed);
            final var aYOnXIntersectionWithoutSpeed = fxAYWithoutSpeed.execute(intersectionYWithoutSpeed);
            final var bYOnYIntersectionWithoutSpeed = fxBYWithoutSpeed.execute(intersectionYWithoutSpeed);

         //   if (
         //       aXOnXIntersectionWithoutSpeed.equals(bXOnYIntersectionWithoutSpeed) &&
         //       aYOnXIntersectionWithoutSpeed.equals(bYOnYIntersectionWithoutSpeed)
         //   ) {
                final var aXOnXTimeUntilIntersection = intersectionXWithoutSpeed.divide(this.pointA.vector.speed);
                final var bXOnXTimeUntilIntersection = intersectionXWithoutSpeed.divide(this.pointB.vector.speed);
                final var aYOnYTimeUntilIntersection = intersectionYWithoutSpeed.divide(this.pointA.vector.speed);
                final var bYOnYTimeUntilIntersection = intersectionYWithoutSpeed.divide(this.pointB.vector.speed);

                final var aXOnXIntersection = fxAX.execute(aXOnXTimeUntilIntersection).roundedValue();
                final var bXOnXIntersection = fxBX.execute(bXOnXTimeUntilIntersection).roundedValue();
                final var aYOnYIntersection = fxAY.execute(aYOnYTimeUntilIntersection).roundedValue();
                final var bYOnYIntersection = fxBY.execute(bYOnYTimeUntilIntersection).roundedValue();

                if ( 
                  aXOnXIntersection.equals(bXOnXIntersection) &&
                  aYOnYIntersection.equals(bYOnYIntersection)
                ) {
                    final var timeUntilCollision = PreciseDecimal.min(aXOnXTimeUntilIntersection, bXOnXTimeUntilIntersection);
                    final var timeDifferenceToPoint = aXOnXTimeUntilIntersection.minus(bXOnXTimeUntilIntersection).abs();
                    final var aXIntersection = fxAXWithoutSpeed.execute(intersectionXWithoutSpeed);
                    final var aYIntersection = fxAYWithoutSpeed.execute(intersectionXWithoutSpeed);
    
                    if (
                        aXOnXTimeUntilIntersection.greaterThan(PreciseDecimal.from(0)) &&
                        bXOnXTimeUntilIntersection.greaterThan(PreciseDecimal.from(0)) && 
                        aYOnYTimeUntilIntersection.greaterThan(PreciseDecimal.from(0)) &&
                        bYOnYTimeUntilIntersection.greaterThan(PreciseDecimal.from(0))
                    )
                        return new PointInRouteOfCollisionOutputDTOBuilder()
                            .setA(this.pointA.id)
                            .setB(this.pointB.id)
                            .setTimeUntilCollision(timeUntilCollision.round())
                            .setCollisionPoint(CartesianPoint.from(aXIntersection, aYIntersection).round())
                            .setTimeDifferenceToPoint(timeDifferenceToPoint)
                            .build();
                }


         //   }
        }

        /*if (intersectionYWithoutSpeed != null) {
            final var aXIntersectionWithoutSpeed = fxAXWithoutSpeed.execute(intersectionYWithoutSpeed).roundedValue();
            final var aYIntersectionWithoutSpeed = fxAYWithoutSpeed.execute(intersectionYWithoutSpeed).roundedValue();
            final var bXIntersectionWithoutSpeed = fxBXWithoutSpeed.execute(intersectionYWithoutSpeed).roundedValue();
            final var bYIntersectionWithoutSpeed = fxBYWithoutSpeed.execute(intersectionYWithoutSpeed).roundedValue();

            //  System.out.println(this.pointA);
            if (this.pointA.toString().equals("{ id: 1, point: (CARTESIAN, 5, 2), vector: (10º, 2 km/h) }")) {
                System.out.println(aXIntersectionWithoutSpeed);
                System.out.println(aYIntersectionWithoutSpeed);
                System.out.println(bXIntersectionWithoutSpeed);
                System.out.println(bYIntersectionWithoutSpeed);
            }
            if (
                aXIntersectionWithoutSpeed.equals(bXIntersectionWithoutSpeed) &&
                aYIntersectionWithoutSpeed.equals(bYIntersectionWithoutSpeed)
            ) {
                final var aXTimeUntilIntersection = intersectionYWithoutSpeed.divide(this.pointA.vector.speed);
                final var bXTimeUntilIntersection = intersectionYWithoutSpeed.divide(this.pointB.vector.speed);
                final var aYTimeUntilIntersection = intersectionYWithoutSpeed.divide(this.pointA.vector.speed);
                final var bYTimeUntilIntersection = intersectionYWithoutSpeed.divide(this.pointB.vector.speed);

                if (this.pointA.toString().equals("{ id: 1, point: (CARTESIAN, 5, 2), vector: (10º, 2 km/h) }")) {
                    System.out.println(this.pointA);
                    System.out.println(aXTimeUntilIntersection.roundedValue());
                    System.out.println(bXTimeUntilIntersection.roundedValue());
                    System.out.println(aYTimeUntilIntersection.roundedValue());
                    System.out.println(bYTimeUntilIntersection.roundedValue());
                    System.out.println(intersectionXWithoutSpeed);
                    System.out.println(intersectionYWithoutSpeed);
                }

                final var timeUntilCollision = PreciseDecimal.min(aXTimeUntilIntersection, bXTimeUntilIntersection);
                final var timeDifferenceToPoint = aXTimeUntilIntersection.minus(bXTimeUntilIntersection).abs();
                final var aXIntersection = fxAXWithoutSpeed.execute(intersectionYWithoutSpeed);
                final var aYIntersection = fxAYWithoutSpeed.execute(intersectionYWithoutSpeed);
    
                if (
                    aXTimeUntilIntersection.greaterThan(PreciseDecimal.from(0)) &&
                    bXTimeUntilIntersection.greaterThan(PreciseDecimal.from(0)) && 
                    aYTimeUntilIntersection.greaterThan(PreciseDecimal.from(0)) &&
                    bYTimeUntilIntersection.greaterThan(PreciseDecimal.from(0))
                )
                    return new PointInRouteOfCollisionOutputDTOBuilder()
                        .setA(this.pointA.id)
                        .setB(this.pointB.id)
                        .setTimeUntilCollision(timeUntilCollision.round())
                        .setCollisionPoint(CartesianPoint.from(aXIntersection, aYIntersection).round())
                        .setTimeDifferenceToPoint(timeDifferenceToPoint)
                        .build();
            }
        }*/

        return null;
    }
}
