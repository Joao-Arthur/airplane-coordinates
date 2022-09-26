import { airplaneType } from '../../models';

type paramsType = {
    readonly airplanes: readonly airplaneType[];
    readonly maxTime: number
};

type returnType = {
    readonly a: string;
    readonly b: string;
    readonly timeUntilCollision: number;
    readonly timeDifferenceToPoint: number;
}[];

export function airplanesInRouteOfCollisionBusiness({ airplanes, maxTime }: paramsType): returnType {

}