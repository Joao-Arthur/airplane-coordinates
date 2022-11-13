import { cartesianPlane } from '../../../../core/cartesianPlane';
import { airplaneType } from '../../models';

type paramsType = {
    readonly airplane: airplaneType;
    readonly x: number;
    readonly y: number;
}

export function scalonateAirplaneCoordinatesBusiness({ airplane, x, y }: paramsType): airplaneType {
    return {
        ...airplane,
        planePoint: cartesianPlane.scalonate({
            point: airplane.planePoint,
            factor: { x, y },
        }),
    };
} 
