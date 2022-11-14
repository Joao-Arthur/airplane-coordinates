import { pipe } from 'ramda';
import { cartesianPlane } from '../../../../core/cartesianPlane';
import { planePoint } from '../../../../core/planePoint';
import { polarPlane } from '../../../../core/polarPlane';
import { airplaneType } from '../../models';

type paramsType = {
    readonly airplane: airplaneType;
    readonly angle: number;
    readonly centerOfRotationX: number;
    readonly centerOfRotationY: number;
}

export function rotateAirplaneCoordinatesBusiness({
    airplane,
    angle,
    centerOfRotationX,
    centerOfRotationY,
}: paramsType): airplaneType {
    return {
        ...airplane,
        planePoint: pipe(
            point => ({
                x: point.x - centerOfRotationX,
                y: point.y - centerOfRotationY,
            }),
            point => polarPlane.fromCartesian(point),
            point => polarPlane.rotate({ point, angle }),
            point => cartesianPlane.fromPolar(point),
            point => ({
                x: point.x + centerOfRotationX,
                y: point.y + centerOfRotationY,
            }),
            point => planePoint.fromCartesian(point),
        )(planePoint.toCartesian(airplane.planePoint)),
    };
}
