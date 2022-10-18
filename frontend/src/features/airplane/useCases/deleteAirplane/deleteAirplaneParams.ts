import { loggerRepositoryType } from '../../../logger/ports/loggerRepository';
import { airplaneType } from '../../models';
import { airplaneRepositoryType } from '../../ports/airplaneRepository';

export type deleteAirplaneParamsType = {
    readonly logger: loggerRepositoryType;
    readonly airplaneRepository: airplaneRepositoryType;
    readonly selectedIds: readonly airplaneType['id'][];
};
