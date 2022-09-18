import { airplaneType } from '../../models/airplane';

type paramsType = {
    readonly id: string;
    readonly x: number;
    readonly y: number;
    readonly radius: number;
    readonly angle: number;
    readonly speed: number;
    readonly direction: number;
};

export function addAirplaneBusiness({
    id,
    x,
    y,
    radius,
    angle,
    speed,
    direction,
}: paramsType): airplaneType {
    return {
        id,
        x,
        y,
        // radius,
        // angle,
        speed,
        direction,
    };
}
