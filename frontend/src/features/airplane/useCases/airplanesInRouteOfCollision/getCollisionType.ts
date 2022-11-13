import { linearFunction } from '../../../../core/linearFunction';
import { trigonometry } from '../../../../core/trigonometry';
import { airplaneType } from '../../models';

type paramsType = {
    a: airplaneType;
    b: airplaneType;
}

export function getCollisionType({ a, b }: paramsType) {
    if (a.planePoint.x === b.planePoint.x && a.planePoint.y === b.planePoint.y)
        return 'SAME_POSITION';
    if (
        [90, 270].includes(trigonometry.fixAngle(a.vector.direction)) &&
        [90, 270].includes(trigonometry.fixAngle(b.vector.direction))
    ) {
        if (a.planePoint.x === b.planePoint.x)
            return 'INFINITE_TANGENT_SAME_X';
        return 'PARALLEL_LINES';
    }
    if (
        [90, 270].includes(a.vector.direction) ||
        [90, 270].includes(b.vector.direction)
    )
        return 'INFINITE_TANGENT_IN_ONE_AIRPLANE';
    const fx = linearFunction.fromPoint({ point: a.planePoint, angle: a.vector.direction });
    const gx = linearFunction.fromPoint({ point: b.planePoint, angle: b.vector.direction });
    if (fx.a === gx.a) {
        if (fx.b === gx.b)
            return 'SAME_FUNCTION';
        return 'PARALLEL_LINES';
    }
    return 'DIFFERENT_FUNCTIONS';
}
