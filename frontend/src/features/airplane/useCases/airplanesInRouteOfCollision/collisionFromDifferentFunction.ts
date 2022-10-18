import { cartesianPlane } from '../../../../core/cartesianPlane';
import { linearFunction } from '../../../../core/linearFunction';
import { mechanics } from '../../../../core/mechanics';
import { airplaneType } from '../../models';

type paramsType = {
    readonly a: airplaneType;
    readonly b: airplaneType;
}

export function collisionFromDifferentFunction({ a, b }: paramsType) {
    const fx = linearFunction.fromPoint({ point: { x: a.x, y: a.y }, angle: a.direction });
    const gx = linearFunction.fromPoint({ point: { x: b.x, y: b.y }, angle: b.direction });
    const intersectionPoint = linearFunction.findInsersectionPoint({
        fx,
        gx,
    });
    if (!intersectionPoint)
        return undefined;
    const aDistance = cartesianPlane.distance({ x: a.x, y: a.y }, intersectionPoint);
    const aTimeTo = mechanics.timeToPoint({ speed: a.speed, distance: aDistance });
    if (aTimeTo < 0)
        return undefined;
    const bDistance = cartesianPlane.distance({ x: b.x, y: b.y }, intersectionPoint);
    const bTimeTo = mechanics.timeToPoint({ speed: b.speed, distance: bDistance });
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
        collisionPoint: intersectionPoint,
        timeDifferenceToPoint,
    } as const;
}
