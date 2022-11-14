import { polarPlane } from '../../polarPlane';
import { polarPointType } from '../../polarPlane/polarPoint';
import { planePointType } from '../planePointType';

export function toPolar(point: planePointType): polarPointType {
    switch (point.type) {
        case 'CARTESIAN':
            return polarPlane.fromCartesian({
                x: point.a,
                y: point.b,
            });
        case 'POLAR':
            return {
                r: point.a,
                a: point.b,
            };
    }
}
