import { numberFns } from '../../numberFns';
import { cartesianPointType } from '../../cartesianPlane/cartesianPoint';
import { polarPointType } from '../polarPoint';
import { trigonometry } from '../../trigonometry';

export function fromCartesian({ x, y }: cartesianPointType): polarPointType {
    return {
        r: numberFns.fix(Math.sqrt(x ** 2 + y ** 2)),
        // Math.atan2 returns negative angle on third and fourth quadrants
        a: trigonometry.fixAngle(Math.atan2(y, x) * 180 / Math.PI),
    };
}
