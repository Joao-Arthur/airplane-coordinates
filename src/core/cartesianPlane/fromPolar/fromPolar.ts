import { numberFns } from '../../numberFns';
import { cartesianPointType } from '../cartesianPoint';
import { polarPointType } from '../polarPoint';

export function fromPolar({ r, angle }: polarPointType): cartesianPointType {
    return {
        x: numberFns.toScale(r * Math.cos(angle * Math.PI / 180), 14),
        y: numberFns.toScale(r * Math.sin(angle * Math.PI / 180), 14),
    };
}
