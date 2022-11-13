import { trigonometry } from '../../trigonometry';
import { polarPointType } from '../polarPoint';

type paramsType = {
    readonly point: polarPointType;
    readonly angle: number;
}

export function rotate({ point, angle }: paramsType): polarPointType {
    return {
        r: point.r,
        a: trigonometry.fixAngle(point.a + angle),
    } as const;
}
