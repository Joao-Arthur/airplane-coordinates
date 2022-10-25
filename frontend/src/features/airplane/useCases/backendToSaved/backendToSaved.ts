import { backendPlanePointType } from '../../../backend/models/backendPlanePoint';
import { planeType } from '../../../backend/models/planeType';
import { airplaneCoordinatesType } from '../../models/savedAirplane';

export function backendToSaved(point: backendPlanePointType): airplaneCoordinatesType {
    function getType() {
        switch (point.plane_type) {
            case planeType.CARTESIAN: return 'cartesian';
            case planeType.POLAR: return 'polar';
        }
    }

    return {
        type: getType(),
        a: point.a,
        b: point.b,
    };
}
