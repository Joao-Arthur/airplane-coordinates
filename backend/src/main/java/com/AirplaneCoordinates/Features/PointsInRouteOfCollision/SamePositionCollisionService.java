package com.AirplaneCoordinates.Features.PointsInRouteOfCollision;

import com.AirplaneCoordinates.Features.PlanePointWithVector;



public class SamePositionCollisionService implements CollisionPointService {
    private final PlanePointWithVector pointA;
    private final PlanePointWithVector pointB;
    
    public SamePositionCollisionService(
        final PlanePointWithVector pointA,
        final PlanePointWithVector pointB
    ) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public PointsCollisionDTO getCollisionPoint() {
        /*

        type paramsType = {
            readonly a: airplaneType;
            readonly b: airplaneType;
        }
        
        export function collisionFromSamePosition({ a, b }: paramsType) {
            return {
                a: a.id,
                b: b.id,
                timeUntilCollision: 0,
                collisionPoint: { x: a.x, y: a.y },
                timeDifferenceToPoint: 0,
            };
        }

        */

        return null;
    }
}