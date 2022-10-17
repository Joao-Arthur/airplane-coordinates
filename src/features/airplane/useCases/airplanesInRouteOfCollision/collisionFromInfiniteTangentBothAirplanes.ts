import { mechanics } from '../../../../core/mechanics';
import { airplaneType } from '../../models';

type paramsType = {
    readonly a: airplaneType;
    readonly b: airplaneType;
}

export function collisionFromInfiniteTangentBothAirplanes({ a, b }: paramsType) {
    const { x, y } = mechanics.collision({
        a: { initialPoint: a.y, speed: a.direction === 90 ? a.speed : -a.speed },
        b: { initialPoint: b.y, speed: b.direction === 90 ? b.speed : -b.speed },
    });
    if (!Number.isFinite(x) || !Number.isFinite(y))
        return undefined;
    return {
        a: a.id,
        b: b.id,
        timeUntilCollision: x,
        collisionPoint: { x: a.x, y },
        timeDifferenceToPoint: 0,
    };
}
