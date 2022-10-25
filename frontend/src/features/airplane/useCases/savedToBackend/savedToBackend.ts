import { backendPlanePointType } from '../../../backend/models/backendPlanePoint';
import { planeType } from '../../../backend/models/planeType';
import { airplaneCoordinatesType } from '../../models/savedAirplane';


export function savedToBackend(coordinates: airplaneCoordinatesType): backendPlanePointType {
    function getType() {
        switch (coordinates.type) {
            case 'cartesian': return planeType.CARTESIAN;
            case 'polar': return planeType.POLAR;
        }
    }

    return {
        plane_type: getType(),
        a: coordinates.a,
        b: coordinates.b,
    };
}
