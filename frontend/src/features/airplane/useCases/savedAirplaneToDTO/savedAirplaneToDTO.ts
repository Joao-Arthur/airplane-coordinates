import { cartesianPlane } from '../../../../core/cartesianPlane';
import { airplaneType, savedAirplaneType } from '../../models';

export function savedAirplaneToDTO(airplane: savedAirplaneType): airplaneType {
    return {
        id: airplane.id,
        speed: airplane.speed,
        direction: airplane.direction,
        ...(
            (airplane.type === 'cartesian')
                ? {
                    x: Number(airplane.a),
                    y: Number(airplane.b),
                } : cartesianPlane.fromPolar({
                    radius: Number(airplane.a),
                    angle: Number(airplane.b),
                })
        ),
    } as const;
}
