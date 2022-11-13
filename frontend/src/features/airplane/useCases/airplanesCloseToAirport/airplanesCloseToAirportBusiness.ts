import { cartesianPlane } from '../../../../core/cartesianPlane';
import { airplaneType } from '../../models';

type paramsType = {
    readonly airplanes: readonly airplaneType[];
    readonly maxDistance: number
};

export function airplanesCloseToAirportBusiness({
    airplanes,
    maxDistance,
}: paramsType) {
    return airplanes
        .map(({ id, planePoint }) => ({
            id,
            distanceFromAirport: cartesianPlane
                .distance(
                    planePoint,
                    { x: 0, y: 0 },
                ),
        } as const))
        .filter(({ distanceFromAirport }) => distanceFromAirport <= maxDistance)
        .sort((a, b) => (a.distanceFromAirport > b.distanceFromAirport ? 1 : -1));
}
