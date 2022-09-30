import { numberFns } from '../../numberFns';
import { cartesianPointType } from '../cartesianPoint';

type paramsType = {
    readonly point: cartesianPointType;
    readonly factor: cartesianPointType;
}

export function translate({ point, factor }: paramsType): cartesianPointType {
    return {
        x: numberFns.fix(point.x + factor.x),
        y: numberFns.fix(point.y + factor.y),
    };
} 
