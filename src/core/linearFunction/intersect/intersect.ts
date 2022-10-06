import { linearFunctionType } from '../types';

type paramsType = {
    readonly fx: linearFunctionType;
    readonly gx: linearFunctionType;
};

export function intersect({ fx, gx }: paramsType): linearFunctionType {
    return {
        a: fx.a - gx.a,
        b: fx.b - gx.b,
    };
}
