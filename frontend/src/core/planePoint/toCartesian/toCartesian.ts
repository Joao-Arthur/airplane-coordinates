import { cartesianPlane } from '../../cartesianPlane';
import { cartesianPointType } from '../../cartesianPlane/cartesianPoint';
import { planePointType } from '../planePointType';

export function toCartesian(point: planePointType): cartesianPointType {
    switch (point.planeType) {
        case 'CARTESIAN':
            return {
                x: point.a,
                y: point.b,
            };
        case 'POLAR':
            return cartesianPlane.fromPolar({
                r: point.a,
                a: point.b,
            });
    }
}
