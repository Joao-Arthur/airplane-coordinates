import { cartesianPlane } from '../../../../core/cartesianPlane';
import { airplaneType } from '../../models';

type paramsType = {
    readonly airplanes: airplaneType[];
    readonly x: number;
    readonly y: number;
}

export function scalonateAirplaneCoordinatesBusiness({ airplanes, x, y }: paramsType): readonly airplaneType[] {
    return airplanes.map(airplane => ({
        ...airplane,
        ...cartesianPlane.scalonate({
            point: { x: airplane.x, y: airplane.y },
            factor: { x, y }
        })
    }))
} 