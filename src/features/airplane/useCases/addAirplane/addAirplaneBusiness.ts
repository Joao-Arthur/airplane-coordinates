import { airplaneType, savedAirplaneType } from '../../models';
import { airplaneParamsType } from './addAirplaneParams';
import { InvalidAirplaneError } from './InvalidAirplaneError';
import { MaxNumberOfAirplanesExceededError } from './MaxNumberOfAirplanesExceededError';

type paramsType = airplaneParamsType & {
    readonly id: airplaneType['id'];
    readonly maxNumberOfAirplanes: number;
    readonly numberOfAirplanes: number;
};

export function addAirplaneBusiness(params: paramsType): savedAirplaneType {
    const isCartesian = params.x !== undefined && params.y !== undefined;
    const isPolar = params.x !== undefined && params.angle !== undefined;

    if (!isCartesian && !isPolar)
        throw new InvalidAirplaneError();
    if (params.numberOfAirplanes + 1 > params.maxNumberOfAirplanes)
        throw new MaxNumberOfAirplanesExceededError(params.maxNumberOfAirplanes);

    return {
        id: params.id,
        speed: params.speed,
        direction: params.direction,
        ...(isCartesian ? {
            type: 'cartesian',
            x: params.x!,
            y: params.y!,
            radius: undefined,
            angle: undefined,
        } : {
            type: 'polar',
            x: undefined,
            y: undefined,
            radius: params.radius!,
            angle: params.angle!,
        }),
    };
}
