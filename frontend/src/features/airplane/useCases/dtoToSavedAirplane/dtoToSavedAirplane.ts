import { polarPlane } from '../../../../core/polarPlane';
import { airplaneType, savedAirplaneType } from '../../models';

export function dtoToSavedAirplane(airplane: airplaneType, type: 'CARTESIAN' | 'POLAR'): savedAirplaneType {
    const pointAsPolar = polarPlane.fromCartesian({
        x: airplane.x,
        y: airplane.y,
    });

    return {
        id: airplane.id,
        speed: airplane.speed,
        direction: airplane.direction,
        type,
        ...(
            type === 'CARTESIAN'
                ? {
                    a: airplane.x,
                    b: airplane.y,
                } : {
                    a: pointAsPolar.r,
                    b: pointAsPolar.a,
                }
        ),
    } as const;
}
