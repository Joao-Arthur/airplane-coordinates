import { cartesianPlane } from '../../../../core/cartesianPlane';
import { airplaneType } from '../../models';
import { airplaneParamsType } from './addAirplaneParams';
import { InvalidAirplaneError } from './InvalidAirplaneError';

type paramsType = airplaneParamsType & {
    readonly id: string;
};

export function addAirplaneBusiness(params: paramsType): airplaneType {
    const isCartesian = 'x' in params && 'y' in params;
    const isPolar = 'radius' in params && 'angle' in params;
    if (!isCartesian && !isPolar)
        throw new InvalidAirplaneError();
    return {
        id: params.id,
        speed: params.speed,
        direction: params.direction,
        ...(isCartesian
            ? { x: params.x, y: params.y }
            : cartesianPlane.fromPolar({ radius: params.radius, angle: params.angle })
        ),
    };
}
