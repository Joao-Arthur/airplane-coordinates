import { planePoint } from '../../../../core/planePoint';
import { airplaneType } from '../../models';

type paramsType = {
    readonly a: airplaneType;
    readonly b: airplaneType;
}

export function collisionFromSamePosition({ a, b }: paramsType) {
    const aAsCartesian = planePoint.toCartesian(a.planePoint);

    return {
        a: a.id,
        b: b.id,
        timeUntilCollision: 0,
        collisionPoint: aAsCartesian,
        timeDifferenceToPoint: 0,
    } as const;
}
