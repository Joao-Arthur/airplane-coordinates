package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Features.PlanePointWithVector;
public final class InfiniteTangentInOnePointCollisionService implements CollisionPointService {
    private final PlanePointWithVector pointA;
    private final PlanePointWithVector pointB;
    
    public InfiniteTangentInOnePointCollisionService(
        final PlanePointWithVector pointA,
        final PlanePointWithVector pointB
    ) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public final CollisionDTO getCollisionPoint() {
        /*final var fx = linearFunction.fromPoint({ point: { x: a.x, y: a.y }, angle: a.direction });
        final var gx = linearFunction.fromPoint({ point: { x: b.x, y: b.y }, angle: b.direction });
        final var coefficientA = [90, 270].includes(a.direction) ? 0 : Math.abs(Math.cos(a.direction * Math.PI / 180));
        final var coefficientB = [90, 270].includes(b.direction) ? 0 : Math.abs(Math.cos(b.direction * Math.PI / 180));
        final var { y: x } = mechanics.collision({
            a: {
                initialPoint: a.x,
                speed: trigonometry.getValueInEachQuadrant({
                    value: coefficientA * a.speed,
                    angle: a.direction,
                }),
            },
            b: {
                initialPoint: b.x,
                speed: trigonometry.getValueInEachQuadrant({
                    value: coefficientB * b.speed,
                    angle: b.direction,
                }),
            },
        });
        final var y = linearFunction.execute([90, 270].includes(a.direction) ? gx : fx, x);
        if (!Number.isFinite(y))
            return null;
        final var { x: timeToCollisionA } = mechanics.collision({
            a: { initialPoint: [90, 270].includes(a.direction) ? y : x, speed: 0 },
            b: {
                initialPoint: [90, 270].includes(a.direction) ? a.y : a.x,
                speed: trigonometry.getValueInEachQuadrant({
                    value: [90, 270].includes(a.direction) ? a.speed : coefficientA * a.speed,
                    angle: a.direction,
                }),
            },
        });
        if (timeToCollisionA < 0)
            return null;
        final var { x: timeToCollisionB } = mechanics.collision({
            a: { initialPoint: [90, 270].includes(b.direction) ? y : x, speed: 0 },
            b: {
                initialPoint: [90, 270].includes(b.direction) ? b.y : b.x,
                speed: trigonometry.getValueInEachQuadrant({
                    value: [90, 270].includes(b.direction) ? b.speed : coefficientB * b.speed,
                    angle: b.direction,
                }),
            },
        });
        if (timeToCollisionB < 0)
            return null;
        final var timeUntilCollision = Math.min(timeToCollisionA, timeToCollisionB);
        final var timeDifferenceToPoint = Math.abs(timeToCollisionA - timeToCollisionB);



        return new CollisionDTOBuilder()
            .setA(this.pointA.id)
            .setB(this.pointB.id)
            .setTimeUntilCollision(timeUntilCollision)
            .setCollisionPoint(CartesianPoint.from(x, y))
            .setTimeDifferenceToPoint(timeDifferenceToPoint)
            .build();*/
 
        return null;
    }
}
