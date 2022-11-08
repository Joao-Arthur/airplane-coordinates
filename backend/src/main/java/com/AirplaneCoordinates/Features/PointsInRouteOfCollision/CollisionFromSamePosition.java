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

public class CollisionFromSamePosition implements PointsCollision