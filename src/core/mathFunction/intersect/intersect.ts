import { cartesianFunctionType } from '../cartesianFunction';

type paramsType = {
    readonly fx: cartesianFunctionType;
    readonly gx: cartesianFunctionType;
};

export function intersect({ fx, gx }: paramsType): cartesianFunctionType {
    return {
        a: fx.a - gx.a,
        b: fx.b - gx.b,
    };
}
