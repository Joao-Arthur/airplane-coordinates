import { airplaneType } from '../../models';
import { AirplaneNotFoundError } from './AirplaneNotFoundError';

type paramsType = {
    readonly airplanes: readonly airplaneType[];
    readonly airplaneToDelete: airplaneType['id'];
};

export function deleteAirplaneBusiness({
    airplanes,
    airplaneToDelete,
}: paramsType): void {
    if (!airplanes.map(({ id }) => id).includes(airplaneToDelete))
        throw new AirplaneNotFoundError(airplaneToDelete);
}
