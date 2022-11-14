import { polarPlane } from '../../polarPlane';
import { polarPointType } from '../../polarPlane/polarPoint';
import { planePointType } from '../planePointType';

export function toPolar(point: planePointType): polarPointType {
    switch (point.planeType) {
        case 'CARTESIAN':
            return polarPlane.fromCartesian({
                x: Number(point.a),
                y: Number(point.b),
            });
        case 'POLAR':
            return {
                r: Number(point.a),
                a: Number(point.b),
            };
    }
}
