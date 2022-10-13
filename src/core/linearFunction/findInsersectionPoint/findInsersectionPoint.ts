import { cartesianPointType } from '../../cartesianPlane/cartesianPoint';
import { execute } from '../execute';
import { findRoot } from '../findRoot';
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
                x: fx.b,
                y: Number.POSITIVE_INFINITY,
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
    const fnRadix = findRoot(intersectedFn);
    const fy = execute(fx, fnRadix);
 //   const gy = execute(gx, fnRadix);
 //   if (fy !== gy)
 //       throw new Error('divergent function');

    return {
        x: fnRadix,
        y: fy,
    };
}
