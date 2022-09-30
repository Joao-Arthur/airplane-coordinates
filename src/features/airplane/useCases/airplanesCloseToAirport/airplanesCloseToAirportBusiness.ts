import { cartesianPlane } from '../../../../core/cartesianPlane';
import { airplaneType } from '../../models';

type paramsType = {
    readonly airplanes: readonly airplaneType[];
    readonly maxDistance: number
};

type returnType = {
    readonly id: airplaneType['id'];
    readonly distanceFromAirport: number;
}[];

export function airplanesCloseToAirportBusiness({
    airplanes,
    maxDistance,
}: paramsType): returnType {
    return airplanes
        .map(({ id, x, y }) => ({
            id,
            distanceFromAirport: cartesianPlane
                .distance(
                    { x, y },
                    { x: 0, y: 0 },
                ),
        }))
        .filter(({ distanceFromAirport }) => distanceFromAirport <= maxDistance)
        .sort((a, b) => (a.distanceFromAirport > b.distanceFromAirport ? 1 : -1));
}
