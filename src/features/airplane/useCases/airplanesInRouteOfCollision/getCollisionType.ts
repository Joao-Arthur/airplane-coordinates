import { linearFunction } from '../../../../core/linearFunction';
import { airplaneType } from '../../models';

type paramsType = {
    a: airplaneType;
    b: airplaneType;
}

export function getCollisionType({ a, b }: paramsType) {
    if (a.x === b.x && a.y === b.y)
        return 'SAME_POSITION';
    if (
        [90, 270].includes(a.direction % 360) &&
        [90, 270].includes(b.direction % 360)
    ) {
        if (a.x === b.x)
            return 'INFINITE_TANGENT_SAME_X';
        return 'PARALLEL_LINES';
    }
    if (
        [90, 270].includes(a.direction) ||
        [90, 270].includes(b.direction)
    )
        return 'INFINITE_TANGENT_IN_ONE_AIRPLANE';
    const fx = linearFunction.fromPoint({ point: { x: a.x, y: a.y }, angle: a.direction });
    const gx = linearFunction.fromPoint({ point: { x: b.x, y: b.y }, angle: b.direction });
    if (fx.a === gx.a) {
        if (fx.b === gx.b)
            return 'SAME_FUNCTION';
        return 'PARALLEL_LINES';
    }
    return 'DIFFERENT_FUNCTIONS';
}
