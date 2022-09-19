import { cartesianPointType } from '../cartesianPoint';

export function distance(pointA: cartesianPointType, pointB: cartesianPointType) {
    const deltaX = pointA.x - pointB.x;
    const deltaY = pointA.y - pointB.y;
    return Math.sqrt(deltaX ** 2 + deltaY ** 2);
}
