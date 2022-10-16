import { cartesianPointType } from '../../cartesianPlane/cartesianPoint';
import { numberFns } from '../../numberFns';
import { linearFunctionType } from '../types';

type paramsType = {
    readonly point: cartesianPointType;
    readonly angle: number;
};

export function fromPoint({ point: { x, y }, angle }: paramsType): linearFunctionType {
    const angularCoefficient = Math.tan(angle * Math.PI / 180);
    const expected = angularCoefficient * x;
    const linearCoefficient = y - expected;

    return {
        a: numberFns.fix(angularCoefficient),
        b: numberFns.fix(linearCoefficient),
    };
}
