import { arrayFns } from '../../../../core/arrayFns';
import { airplaneType } from '../../models';
import { collisionFromDifferentFunction } from './collisionFromDifferentFunction';
import { collisionFromInfiniteTangentBothAirplanes } from './collisionFromInfiniteTangentBothAirplanes';
import { collisionFromInfiniteTangentInOneAirplane } from './collisionFromInfiniteTangentInOneAirplane';
import { collisionFromSameFunction } from './collisionFromSameFunction';
import { collisionFromSamePosition } from './collisionFromSamePosition';
import { getCollisionType } from './getCollisionType';

type paramsType = {
    readonly airplanes: readonly airplaneType[];
    readonly maxTime: number
};

export function airplanesInRouteOfCollisionBusiness({ airplanes, maxTime }: paramsType) {
    return arrayFns
        .combination(airplanes.map(({ id }) => id))
        .map(([a, b]) => ({
            a: airplanes.find(({ id }) => id === a) as airplaneType,
            b: airplanes.find(({ id }) => id === b) as airplaneType,
        }))
        .map(({ a, b }) => {
            switch (getCollisionType({ a, b })) {
                case 'SAME_POSITION':
                    return collisionFromSamePosition({ a, b });
                case 'INFINITE_TANGENT_SAME_X':
                    return collisionFromInfiniteTangentBothAirplanes({ a, b });
                case 'INFINITE_TANGENT_IN_ONE_AIRPLANE':
                    return collisionFromInfiniteTangentInOneAirplane({ a, b });
                case 'SAME_FUNCTION':
                    return collisionFromSameFunction({ a, b });
                case 'DIFFERENT_FUNCTIONS':
                    return collisionFromDifferentFunction({ a, b });
                case 'PARALLEL_LINES':
                    return undefined;
            }
        })
        .filter(result => !!result)
        .map(result => result as Exclude<typeof result, undefined>)
        .filter(({ timeDifferenceToPoint }) => timeDifferenceToPoint <= maxTime)
        .sort((a, b) => (a.timeUntilCollision > b.timeUntilCollision ? 1 : -1));
}
