import { mechanics } from '../../../../core/mechanics';
import { planePoint } from '../../../../core/planePoint';
import { airplaneType } from '../../models';

type paramsType = {
    readonly a: airplaneType;
    readonly b: airplaneType;
}

export function collisionFromInfiniteTangentBothAirplanes({ a, b }: paramsType) {
    const aAsCartesian = planePoint.toCartesian(a.planePoint);
    const bAsCartesian = planePoint.toCartesian(b.planePoint);

    const { x: timeUntilCollision, y } = mechanics.collision({
        a: { initialPoint: aAsCartesian.y, speed: a.vector.direction === 90 ? a.vector.speed : -a.vector.speed },
        b: { initialPoint: bAsCartesian.y, speed: b.vector.direction === 90 ? b.vector.speed : -b.vector.speed },
    });
    if (!Number.isFinite(timeUntilCollision) || !Number.isFinite(y))
        return undefined;
    return {
        a: a.id,
        b: b.id,
        timeUntilCollision,
        collisionPoint: { x: aAsCartesian.x, y },
        timeDifferenceToPoint: 0,
    } as const;
}
