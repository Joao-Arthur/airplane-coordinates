import { numberFns } from '../../numberFns';
import { cartesianPointType } from '../../cartesianPlane/cartesianPoint';
import { polarPointType } from '../polarPoint';

export function fromCartesian({ x, y }: cartesianPointType): polarPointType {
    return {
        radius: numberFns.toScale(Math.sqrt(x ** 2 + y ** 2), 14),
        angle: numberFns.toScale(Math.atan(y / x), 14),
    };
}
