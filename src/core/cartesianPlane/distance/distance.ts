import { pointType } from '../../point';

export function distance(pointA: pointType, pointB: pointType) {
    const deltaX = pointA.x - pointB.x;
    const deltaY = pointA.y - pointB.y;
    return Math.sqrt(deltaX ** 2 + deltaY ** 2);
}
