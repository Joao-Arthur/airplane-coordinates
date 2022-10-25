import { cartesianPlane } from '../../../../core/cartesianPlane';
import { savedAirplaneType } from '../../models';

type paramsType = {
    readonly airplane: savedAirplaneType;
    readonly x: number;
    readonly y: number;
}

export function translateAirplaneCoordinatesBusiness({ airplane, x, y }: paramsType): {
    return {
    ...airplane,
    ...cartesianPlane.translate({
        point: { x: airplane.x, y: airplane.y },
        factor: { x, y },
    }),
} as const;
} 
