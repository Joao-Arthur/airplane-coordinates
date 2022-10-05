import { cartesianPlane } from '../../../../core/cartesianPlane';
import { airplaneType, savedAirplaneType } from '../../models';

export function savedAirplaneToDTO(airplane: savedAirplaneType): airplaneType {
    return {
        id: airplane.id,
        speed: airplane.speed,
        direction: airplane.direction,
        ...(
            (airplane.x && airplane.y)
                ? {
                    x: airplane.x!,
                    y: airplane.y!,
                } : cartesianPlane.fromPolar({
                    radius: airplane.radius!,
                    angle: airplane.angle!,
                })
        ),
    };
}