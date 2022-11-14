import { cartesianPlane } from '../../../../core/cartesianPlane';
import { planePoint } from '../../../../core/planePoint';
import { airplaneType } from '../../models';

type paramsType = {
    readonly airplane: airplaneType;
    readonly x: number;
    readonly y: number;
}

export function translateAirplaneCoordinatesBusiness({ airplane, x, y }: paramsType): airplaneType {
    return {
        ...airplane,
        planePoint: planePoint.fromCartesian(cartesianPlane.translate({
            point: planePoint.toCartesian(airplane.planePoint),
            factor: { x, y },
        })),
    };
} 
