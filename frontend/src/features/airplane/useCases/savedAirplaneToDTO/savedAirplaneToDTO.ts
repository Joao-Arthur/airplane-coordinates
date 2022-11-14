import { planePoint } from '../../../../core/planePoint';
import { airplaneType, savedAirplaneType } from '../../models';

export function savedAirplaneToDTO(airplane: savedAirplaneType): airplaneType {
    return {
        id: airplane.id,
        planePoint: planePoint.toCartesian(airplane.planePoint),
        vector: airplane.vector,
    };
}
