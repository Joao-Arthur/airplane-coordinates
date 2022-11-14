import { polarPointType } from '../polarPlane/polarPoint';
import { planePointType } from './planePointType';

export function fromPolar(point: polarPointType): planePointType {
    return {
        planeType: 'POLAR',
        a: String(point.r),
        b: String(point.a),
    };
}
