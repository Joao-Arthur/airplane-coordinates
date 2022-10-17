import { cartesianPlane } from '../../../../core/cartesianPlane';
import { linearFunction } from '../../../../core/linearFunction';
import { mechanics } from '../../../../core/mechanics';
import { polarPlane } from '../../../../core/polarPlane';
import { airplaneType } from '../../models';

type paramsType = {
    readonly a: airplaneType;
    readonly b: airplaneType;
}

function getSignInEachQuadrant(speed: number, angle: number) {
    if (angle < 90)
        return speed;
    if (angle < 180)
        return -speed;
    if (angle < 270)
        return -speed;
    return speed;
}

export function collisionFromSameFunction({ a, b }: paramsType) {
    const fx = linearFunction.fromPoint({
        point: { x: a.x, y: a.y },
        angle: a.direction,
    });
    const distance = cartesianPlane.distance(
        { x: a.x, y: a.y },
        { x: b.x, y: b.y },
    );
    const polarPoint = polarPlane.fromCartesian({
        x: b.x - a.x,
        y: b.y - a.y,
    });
    //console.log(distance, polarPoint.angle);
    const { x: absoluteCollisionPoint } = mechanics.collision({
        a: { initialPoint: 0, speed: getSignInEachQuadrant(a.speed, a.direction) },
        b: { initialPoint: distance, speed: getSignInEachQuadrant(b.speed, b.direction) },
    });
    const collisionPointX = absoluteCollisionPoint * Math.abs(Math.sin(a.direction * Math.PI / 180));
    console.log(collisionPointX);

    const aTimeTo = mechanics.timeToPoint({ speed: a.speed, distance: collisionPointX });
    if (aTimeTo < 0)
        return undefined;
    const bTimeTo = mechanics.timeToPoint({ speed: b.speed, distance: collisionPointX });
    if (bTimeTo < 0)
        return undefined;
    const timeUntilCollision = Math.min(aTimeTo, bTimeTo);
    const timeDifferenceToPoint = aTimeTo - bTimeTo;
    if (timeDifferenceToPoint < 0)
        return undefined;
    return {
        a: a.id,
        b: b.id,
        timeUntilCollision,
        collisionPoint: {
            x: collisionPointX,
            y: linearFunction.execute(fx, collisionPointX),
        },
        timeDifferenceToPoint,
    } as const;

}
