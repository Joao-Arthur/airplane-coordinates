import { cartesianPointType } from '../cartesianPoint';
import { squareType } from '../square';

type paramsType = {
    readonly point: cartesianPointType;
    readonly size: number;
}

export function pointToSquare({ point, size }: paramsType): squareType {
    return {
        x: point.x - size / 2,
        y: point.y - size / 2,
        width: size,
        height: size,
    };
}
