import { numberFns } from '../../numberFns';
import { cartesianPointType } from '../../cartesianPlane/cartesianPoint';
import { polarPointType } from '../polarPoint';

export function fromCartesian({ x, y }: cartesianPointType): polarPointType {
    return {
        radius: numberFns.fix(Math.sqrt(x ** 2 + y ** 2)),
        // Math.atan2 retorna negativo no terceiro e quarto quadrantes
        angle: (numberFns.fix((Math.atan2(y, x) * 180 / Math.PI)) + 360) % 360,
    } as const;
}
