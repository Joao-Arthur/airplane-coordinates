import { backendCartesianPointType } from '../../../../core/cartesianPlane/backendCartesianPoint';
import { loggerRepositoryType } from '../../../logger/ports/loggerRepository';
import { airplaneType } from '../../models';
import { airplaneRepositoryType } from '../../ports/airplaneRepository';

export type rotateAirplaneCoordinatesParamsType = {
    readonly logger: loggerRepositoryType;
    readonly airplaneRepository: airplaneRepositoryType;
    readonly selectedIds: readonly airplaneType['id'][];
    readonly angle: string;
    readonly centerOfRotation: backendCartesianPointType;
};
