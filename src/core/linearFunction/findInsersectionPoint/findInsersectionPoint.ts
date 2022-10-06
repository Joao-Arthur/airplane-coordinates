import { cartesianPointType } from '../../cartesianPlane/cartesianPoint';
import { execute } from '../execute';
import { findRadix } from '../findRadix';
import { intersect } from '../intersect';
import { linearFunctionType } from '../types';

type paramsType = {
    readonly fx: linearFunctionType;
    readonly gx: linearFunctionType;
};

export function findInsersectionPoint({ fx, gx }: paramsType): cartesianPointType | undefined {
    if (!Number.isFinite(fx.a) && !Number.isFinite(gx.a)) {
        if (fx.b === gx.b)
            return {
                a: Number.POSITIVE_INFINITY,
                b: fx.b,
            };

        return undefined;
    }
    if (!Number.isFinite(fx.a))
        return {
            x: fx.b,
            y: execute(gx, fx.b),
        };
    if (!Number.isFinite(gx.a))
        return {
            x: gx.b,
            y: execute(fx, gx.b),
        };
    const intersectedFn = intersect({ fx, gx });
    const fnRadix = findRadix(intersectedFn);
    const fy = execute(fx, fnRadix);
    return {
        x: fnRadix,
        y: fy,
    };
}
