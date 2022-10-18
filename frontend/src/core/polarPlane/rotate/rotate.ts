import { trigonometry } from '../../trigonometry';
import { polarPointType } from '../polarPoint';

type paramsType = {
    readonly point: polarPointType;
    readonly angle: number;
}

export function rotate({ point, angle }: paramsType): polarPointType {
    return {
        radius: point.radius,
        angle: trigonometry.fixAngle(point.angle + angle),
    } as const;
}
