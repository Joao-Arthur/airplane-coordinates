import { cartesianPlane } from '../../../../core/cartesianPlane';
import { cartesianPointType } from '../../../../core/cartesianPlane/cartesianPoint';
import { airplaneType } from '../../models';

export function getPosition(airplane: airplaneType): cartesianPointType {
    return (airplane.x && airplane.y)
        ? {
            x: airplane.x,
            y: airplane.y,
        }
        : cartesianPlane.fromPolar({
            radius: airplane.radius!,
            angle: airplane.angle!,
        });
}
