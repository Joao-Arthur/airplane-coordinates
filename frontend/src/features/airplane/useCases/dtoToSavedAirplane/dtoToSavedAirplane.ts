import { polarPlane } from '../../../../core/polarPlane';
import { airplaneType, savedAirplaneType } from '../../models';

export function dtoToSavedAirplane(airplane: airplaneType, type: 'CARTESIAN' | 'POLAR'): savedAirplaneType {
    const pointAsPolar = polarPlane.fromCartesian({
        x: airplane.x,
        y: airplane.y,
    });

    return {
        id: airplane.id,
        planePoint: type === 'CARTESIAN'
            ? {
                type: 'CARTESIAN',
                a: airplane.x,
                b: airplane.y,
            } : {
                type: 'POLAR',
                a: pointAsPolar.r,
                b: pointAsPolar.a,
            },
        vector: airplane.vector,
    };
}
