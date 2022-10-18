import { numberFns } from '../../numberFns';
import { cartesianPointType } from '../cartesianPoint';
import { polarPointType } from '../../polarPlane/polarPoint';

export function fromPolar({ radius, angle }: polarPointType): cartesianPointType {
    return {
        x: numberFns.fix(radius * Math.cos(angle * Math.PI / 180)),
        y: numberFns.fix(radius * Math.sin(angle * Math.PI / 180)),
    } as const;
}
