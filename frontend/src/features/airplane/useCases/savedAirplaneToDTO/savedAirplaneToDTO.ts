import { cartesianPlane } from '../../../../core/cartesianPlane';
import { airplaneType, savedAirplaneType } from '../../models';

export function savedAirplaneToDTO(airplane: savedAirplaneType): airplaneType {
    return {
        id: airplane.id,
        speed: airplane.speed,
        direction: airplane.direction,
        ...(
            (airplane.type === 'CARTESIAN')
                ? {
                    x: airplane.a,
                    y: airplane.b,
                } : cartesianPlane.fromPolar({
                    r: airplane.a,
                    a: airplane.b,
                })
        ),
    } as const;
}
