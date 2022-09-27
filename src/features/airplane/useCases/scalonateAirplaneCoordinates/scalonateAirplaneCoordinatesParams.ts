import { loggerRepositoryType } from '../../../logger/ports/loggerRepository';
import { airplaneRepositoryType } from '../../ports/airplaneRepository';

export type scalonateAirplaneCoordinatesParamsType = {
    readonly logger: loggerRepositoryType;
    readonly airplaneRepository: airplaneRepositoryType;
    readonly selectedIds: readonly string[];
    readonly x: number;
    readonly y: number;
};
