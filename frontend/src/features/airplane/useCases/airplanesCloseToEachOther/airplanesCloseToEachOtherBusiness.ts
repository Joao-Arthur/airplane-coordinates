import { arrayFns } from '../../../../core/arrayFns';
import { cartesianPlane } from '../../../../core/cartesianPlane';
import { airplaneType } from '../../models';

type paramsType = {
    readonly airplanes: readonly airplaneType[];
    readonly maxDistance: number
};

export function airplanesCloseToEachOtherBusiness({
    airplanes,
    maxDistance,
}: paramsType) {
    return arrayFns
        .combination(airplanes.map(({ id }) => id))
        .map(([a, b]) => ({
            a: airplanes.find(({ id }) => id === a) as airplaneType,
            b: airplanes.find(({ id }) => id === b) as airplaneType,
        }))
        .map(
            ({ a, b }) => ({
                a: a.id,
                b: b.id,
                distance: cartesianPlane.distance(a, b),
            } as const),
        )
        .filter(({ distance }) => distance <= maxDistance)
        .sort((a, b) => (a.distance > b.distance ? 1 : -1));
}
