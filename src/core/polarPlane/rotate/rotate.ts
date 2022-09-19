import { numberFns } from "../../numberFns";
import { polarPointType } from "../polarPoint";

type paramsType = {
    readonly point: polarPointType;
    readonly angle: number;
}

export function rotate({ point, angle }: paramsType): polarPointType {
    return {
        radius: point.radius,
        angle: numberFns.fix(((point.angle + angle) + 360) % 360)
    }
}