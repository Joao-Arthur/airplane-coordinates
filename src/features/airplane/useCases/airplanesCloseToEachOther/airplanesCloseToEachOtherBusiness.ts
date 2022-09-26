import { arrayFns } from '../../../../core/arrayFns';
import { cartesianPlane } from '../../../../core/cartesianPlane';
import { airplaneType } from '../../models';

type paramsType = {
    readonly airplanes: readonly airplaneType[];
    readonly maxDistance: number
};

type returnType = {
    readonly a: string;
    readonly b: string;
    readonly distance: number;
}[];

export function airplanesCloseToEachOtherBusiness({
    airplanes,
    maxDistance,
}: paramsType): returnType {
    return arrayFns
        .combination(airplanes.map(({ id }) => id))
        .map(
            ([a, b]) => ({
                a,
                b,
                distance: cartesianPlane
                    .distance(
                        {
                            x: airplanes.find(({ id }) => id === a)!.x,
                            y: airplanes.find(({ id }) => id === a)!.y,
                        },
                        {
                            x: airplanes.find(({ id }) => id === b)!.x,
                            y: airplanes.find(({ id }) => id === b)!.y,
                        },
                    ),
            }),
        ).filter(({ distance }) => distance <= maxDistance)
        .sort((a, b) => (a.distance > b.distance ? 1 : -1));
}