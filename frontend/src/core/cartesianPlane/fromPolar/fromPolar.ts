import { numberFns } from '../../numberFns';
import { cartesianPointType } from '../cartesianPoint';
import { polarPointType } from '../../polarPlane/polarPoint';

export function fromPolar({ r, a }: polarPointType): cartesianPointType {
    return {
        x: numberFns.fix(r * Math.cos(a * Math.PI / 180)),
        y: numberFns.fix(r * Math.sin(a * Math.PI / 180)),
    } as const;
}
