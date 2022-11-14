import { cartesianPlane } from '../../../../core/cartesianPlane';
import { planePoint } from '../../../../core/planePoint';
import { airplaneType } from '../../models';

type paramsType = {
    readonly airplane: airplaneType;
    readonly x: number;
    readonly y: number;
}

export function scalonateAirplaneCoordinatesBusiness({ airplane, x, y }: paramsType): airplaneType {
    return {
        ...airplane,
        planePoint: planePoint.fromCartesian(cartesianPlane.scalonate({
            point: planePoint.toCartesian(airplane.planePoint),
            factor: { x, y },
        })),
    };
} 
