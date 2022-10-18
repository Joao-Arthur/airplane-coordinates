import { cartesianPlane } from '../../../../core/cartesianPlane';
import { linearFunction } from '../../../../core/linearFunction';
import { mechanics } from '../../../../core/mechanics';
import { airplaneType } from '../../models';

type paramsType = {
    readonly a: airplaneType;
    readonly b: airplaneType;
}

export function collisionFromInfiniteTangentInOneAirplane({ a, b }: paramsType) {
    if ([90, 270].includes(a.direction)) {
        const gx = linearFunction.fromPoint({ point: { x: b.x, y: b.y }, angle: b.direction });
        const pointB = linearFunction.execute(gx, a.x);
        const intersectionPoint = { x: a.x, y: pointB };
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
    } else {
        const gx = linearFunction.fromPoint({ point: { x: a.x, y: a.y }, angle: a.direction });
        const pointA = linearFunction.execute(gx, b.x);
        const intersectionPoint = { x: b.x, y: pointA };
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
}
