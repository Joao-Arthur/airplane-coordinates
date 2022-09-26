import { cartesianPlane } from '../../../../core/cartesianPlane';
import { airplaneType } from '../../models';
import { InvalidAirplaneError } from './InvalidAirplaneError';

type paramsType = {
    readonly id: string;
    readonly x?: number;
    readonly y?: number;
    readonly radius?: number;
    readonly angle?: number;
    readonly speed: number;
    readonly direction: number;
};

export function addAirplaneBusiness({
    id,
    x,
    y,
    radius,
    angle,
    speed,
    direction,
}: paramsType): airplaneType {
    if (typeof x === 'number' && typeof y === 'number')
        return {
            id,
            x,
            y,
            speed,
            direction,
        };
    if (typeof radius === 'number' && typeof angle === 'number')
        return {
            id,
            ...cartesianPlane.fromPolar({ radius, angle }),
            speed,
            direction,
        };
    throw new InvalidAirplaneError();
}
