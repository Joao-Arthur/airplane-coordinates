import { cartesianPlane } from '../../../../core/cartesianPlane';
import { airplaneType, savedAirplaneType } from '../../models';

export function savedAirplaneToDTO(airplane: savedAirplaneType): airplaneType {
    return {
        id: airplane.id,
        planePoint:
            airplane.planePoint.type === 'CARTESIAN'
                ? {
                    x: airplane.planePoint.a,
                    y: airplane.planePoint.b,
                } : cartesianPlane.fromPolar({
                    r: airplane.planePoint.a,
                    a: airplane.planePoint.b,
                }),
        vector: airplane.vector,
    } as const;
}
