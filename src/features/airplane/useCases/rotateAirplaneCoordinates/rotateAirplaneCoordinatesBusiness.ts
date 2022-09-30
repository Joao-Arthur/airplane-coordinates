import { pipe } from 'ramda';
import { cartesianPlane } from '../../../../core/cartesianPlane';
import { polarPlane } from '../../../../core/polarPlane';
import { airplaneType } from '../../models';

type paramsType = {
    readonly airplanes: readonly airplaneType[];
    readonly angle: number;
    readonly centerOfRotationX: number;
    readonly centerOfRotationY: number;
}

export function rotateAirplaneCoordinatesBusiness({
    airplanes,
    angle,
    centerOfRotationX,
    centerOfRotationY,
}: paramsType): readonly airplaneType[] {
    return airplanes
        .map(airplane => ({
            ...airplane,
            x: airplane.x - centerOfRotationX,
            y: airplane.y - centerOfRotationY,
        }))
        .map(airplane => ({
            ...airplane,
            ...pipe(
                point => polarPlane.fromCartesian(point),
                point => polarPlane.rotate({ point, angle }),
                point => cartesianPlane.fromPolar(point),
            )({ x: airplane.x, y: airplane.y }),
        }))
        .map(airplane => ({
            ...airplane,
            x: airplane.x + centerOfRotationX,
            y: airplane.y + centerOfRotationY,
        }));
}
