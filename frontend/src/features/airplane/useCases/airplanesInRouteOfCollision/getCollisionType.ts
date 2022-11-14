import { linearFunction } from '../../../../core/linearFunction';
import { planePoint } from '../../../../core/planePoint';
import { trigonometry } from '../../../../core/trigonometry';
import { airplaneType } from '../../models';

type paramsType = {
    a: airplaneType;
    b: airplaneType;
}

export function getCollisionType({ a, b }: paramsType) {
    const aAsCartesian = planePoint.toCartesian(a.planePoint);
    const bAsCartesian = planePoint.toCartesian(b.planePoint);
    if (aAsCartesian.x === bAsCartesian.x && aAsCartesian.y === bAsCartesian.y)
        return 'SAME_POSITION';
    if (
        [90, 270].includes(trigonometry.fixAngle(a.vector.direction)) &&
        [90, 270].includes(trigonometry.fixAngle(b.vector.direction))
    ) {
        if (aAsCartesian.x === bAsCartesian.x)
            return 'INFINITE_TANGENT_SAME_X';
        return 'PARALLEL_LINES';
    }
    if (
        [90, 270].includes(a.vector.direction) ||
        [90, 270].includes(b.vector.direction)
    )
        return 'INFINITE_TANGENT_IN_ONE_AIRPLANE';
    const fx = linearFunction.fromPoint({ point: aAsCartesian, angle: a.vector.direction });
    const gx = linearFunction.fromPoint({ point: bAsCartesian, angle: b.vector.direction });
    if (fx.a === gx.a) {
        if (fx.b === gx.b)
            return 'SAME_FUNCTION';
        return 'PARALLEL_LINES';
    }
    return 'DIFFERENT_FUNCTIONS';
}
