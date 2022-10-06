import { cartesianPointType } from '../../cartesianPlane/cartesianPoint';
import { cartesianFunctionType } from '../cartesianFunction';

type paramsType = {
    readonly point: cartesianPointType;
    readonly angle: number; 
};

export function fromPoint({point: { x, y }, angle}: paramsType): cartesianFunctionType {
    if([90, 270].includes((angle + 360) % 360))
        return {
            a: Number.POSITIVE_INFINITY,
            b: x,
        };
    const a = angle * Math.PI / 180;
    
    const expected = a * x;
    const b = y = expected;

    return {
        a,
        b,
    };
}
