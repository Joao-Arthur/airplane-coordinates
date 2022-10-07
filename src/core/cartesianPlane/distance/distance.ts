import { cartesianPointType } from '../cartesianPoint';

export function distance(a: cartesianPointType, b: cartesianPointType) {
    const deltaX = a.x - b.x;
    const deltaY = a.y - b.y;
    return Math.sqrt(deltaX ** 2 + deltaY ** 2);
}
