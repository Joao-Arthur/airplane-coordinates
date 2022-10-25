import { numberFns } from '../../numberFns';
import { cartesianPointType } from '../cartesianPoint';

type polarPointType = {
    readonly radius: number;
    readonly angle: number;
};

export function fromPolar({ radius, angle }: polarPointType): cartesianPointType {
    return {
        x: numberFns.fix(radius * Math.cos(angle * Math.PI / 180)),
        y: numberFns.fix(radius * Math.sin(angle * Math.PI / 180)),
    } as const;
}
