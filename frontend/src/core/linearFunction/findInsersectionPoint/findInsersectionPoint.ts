import { cartesianPointType } from '../../cartesianPlane/cartesianPoint';
import { execute } from '../execute';
import { findRoot } from '../findRoot';
import { intersect } from '../intersect';
import { linearFunctionType } from '../types';

type paramsType = {
    readonly fx: linearFunctionType;
    readonly gx: linearFunctionType;
};

export function findInsersectionPoint({ fx, gx }: paramsType): cartesianPointType {
    const intersectedFn = intersect({ fx, gx });
    const fnRoot = findRoot(intersectedFn);
    const fy = execute(fx, fnRoot);

    return {
        x: fnRoot,
        y: fy,
    } as const;
}
