import { cartesianPointType } from '../cartesianPlane/cartesianPoint';
import { planePointType } from './planePointType';

export function fromCartesian(point: cartesianPointType): planePointType {
    return {
        planeType: 'CARTESIAN',
        a: String(point.x),
        b: String(point.y),
    };
}
