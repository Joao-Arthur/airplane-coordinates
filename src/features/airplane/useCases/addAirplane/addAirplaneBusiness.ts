import { airplaneType } from '../../models';
import { airplaneParamsType } from './addAirplaneParams';
import { MaxNumberOfAirplanesExceededError } from './MaxNumberOfAirplanesExceededError';

type paramsType = airplaneParamsType & {
    readonly id: airplaneType['id'];
    readonly maxNumberOfAirplanes: number;
    readonly numberOfAirplanes: number;
};

export function addAirplaneBusiness(params: paramsType) {
    if (params.numberOfAirplanes + 1 > params.maxNumberOfAirplanes)
        throw new MaxNumberOfAirplanesExceededError(params.maxNumberOfAirplanes);
}
