import { loggerRepositoryType } from '../../../logger/ports/loggerRepository';
import { airplaneRepositoryType } from '../../ports/airplaneRepository';

export type rotateAirplaneCoordinatesParamsType = {
    readonly logger: loggerRepositoryType;
    readonly airplaneRepository: airplaneRepositoryType;
    readonly selectedIds: readonly string[];
    readonly angle: number;
    readonly centerOfRotationX: number;
    readonly centerOfRotationY: number;
};
