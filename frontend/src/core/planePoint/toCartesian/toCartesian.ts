import { cartesianPlane } from '../../cartesianPlane';
import { cartesianPointType } from '../../cartesianPlane/cartesianPoint';
import { planePointType } from '../planePointType';

export function toCartesian(point: planePointType): cartesianPointType {
    switch (point.planeType) {
        case 'CARTESIAN':
            return {
                x: Number(point.a),
                y: Number(point.b),
            };
        case 'POLAR':
            return cartesianPlane.fromPolar({
                r: Number(point.a),
                a: Number(point.b),
            });
    }
}
