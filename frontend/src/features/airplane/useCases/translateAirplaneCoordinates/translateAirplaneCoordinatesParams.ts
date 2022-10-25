import { loggerRepositoryType } from '../../../logger/ports/loggerRepository';
import { airplaneRepositoryType } from '../../ports/airplaneRepository';
import { airplaneType } from '../../models';

export type translateAirplaneCoordinatesParamsType = {
    readonly logger: loggerRepositoryType;
    readonly airplaneRepository: airplaneRepositoryType;
    readonly selectedIds: readonly airplaneType['id'][];
    readonly x: number;
    readonly y: number;
};
