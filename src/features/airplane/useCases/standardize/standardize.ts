import { cartesianPlane } from '../../../../core/cartesianPlane';
import { airplaneType } from '../../models';

type returnType = {
    readonly id: string;
    readonly x: number;
    readonly y: number;
    readonly speed: number;
    readonly direction: number;
}

export function standardize(airplane: airplaneType): returnType {
    return {
        id: airplane.id,
        speed: airplane.speed,
        direction: airplane.direction,
        ...(
            (airplane.x && airplane.y)
                ? {
                    x: airplane.x!,
                    y: airplane.y!,
                } : cartesianPlane.fromPolar({
                    radius: airplane.radius!,
                    angle: airplane.angle!,
                })
        ),
    };
}
