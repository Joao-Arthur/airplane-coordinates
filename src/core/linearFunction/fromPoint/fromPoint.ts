import { cartesianPointType } from '../../cartesianPlane/cartesianPoint';
import { numberFns } from '../../numberFns';
import { cartesianFunctionType } from '../cartesianFunction';

type paramsType = {
    readonly point: cartesianPointType;
    readonly angle: number;
};

export function fromPoint({ point: { x, y }, angle }: paramsType): cartesianFunctionType {
    if ([90, 270].includes(angle % 360))
        return {
            a: Number.POSITIVE_INFINITY,
            b: x,
        };
    const angularCoefficient = Math.tan(angle * Math.PI / 180);
    const expected = angularCoefficient * x;
    const linearCoefficient = y - expected;

    return {
        a: numberFns.fix(angularCoefficient),
        b: numberFns.fix(linearCoefficient),
    };
}
