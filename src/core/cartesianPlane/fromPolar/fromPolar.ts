import { numberFns } from '../../numberFns';
import { cartesianPointType } from '../cartesianPoint';
import { polarPointType } from '../../polarPlane/polarPoint';

export function fromPolar({ radius, angle }: polarPointType): cartesianPointType {
    return {
        x: numberFns.toScale(radius * Math.cos(angle * Math.PI / 180), 14),
        y: numberFns.toScale(radius * Math.sin(angle * Math.PI / 180), 14),
    };
}
