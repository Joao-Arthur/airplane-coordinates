import { cartesianPointType } from '../cartesianPlane/cartesianPoint';
import { planePointType } from './planePointType';

export function fromCartesian(point: cartesianPointType): planePointType {
    return {
        type: 'CARTESIAN',
        a: point.x,
        b: point.y,
    };
}
