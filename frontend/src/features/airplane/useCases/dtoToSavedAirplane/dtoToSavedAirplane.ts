import { polarPlane } from '../../../../core/polarPlane';
import { airplaneType, savedAirplaneType } from '../../models';

export function dtoToSavedAirplane(airplane: airplaneType, type: 'polar' | 'cartesian'): savedAirplaneType {
    return {
        id: airplane.id,
        speed: airplane.speed,
        direction: airplane.direction,
        ...(
            type === 'cartesian'
                ? {
                    type,
                    x: airplane.x,
                    y: airplane.y,
                    radius: undefined,
                    angle: undefined,
                } : {
                    type,
                    x: undefined,
                    y: undefined,
                    ...polarPlane.fromCartesian({
                        x: airplane.x,
                        y: airplane.y,
                    }),
                }
        ),
    } as const;
}
