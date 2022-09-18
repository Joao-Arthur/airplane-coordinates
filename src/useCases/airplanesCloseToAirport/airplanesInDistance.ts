import { cartesianPlane } from '../../core/cartesianPlane';
import { airplaneType } from '../../entities/airplane';

type paramsType = {
    readonly airplanes: readonly airplaneType[];
    readonly maxDistance: number
};

type returnType = {
    readonly id: string;
    readonly distanceFromAirport: number;
}[];

export function airplanesInDistance({ airplanes, maxDistance }: paramsType): returnType {
    return Array.from(airplanes)
        .map(airplane => ({
            ...airplane,
            distanceFromAirport: cartesianPlane
                .distance(
                    { x: airplane.x, y: airplane.y },
                    { x: 0, y: 0 },
                ),
        }))
        .filter(({ distanceFromAirport }) => distanceFromAirport <= maxDistance)
        .sort((a, b) => (a.distanceFromAirport > b.distanceFromAirport ? 1 : -1))
        .map(({ id, distanceFromAirport }) => ({ id, distanceFromAirport }));
}
