import { loggerRepositoryType } from '../../../logger/ports/loggerRepository';
import { uniqueIdentifierType } from '../../../uniqueIdentifier/ports/uniqueIdentifier';
import { savedAirplaneType } from '../../models';
import { airplaneRepositoryType } from '../../ports/airplaneRepository';

export type airplaneParamsType = Omit<savedAirplaneType, 'id'>;

export type addAirplaneParamsType = {
    readonly logger: loggerRepositoryType;
    readonly uniqueIdentifier: uniqueIdentifierType;
    readonly airplaneRepository: airplaneRepositoryType;
    readonly airplaneParams: airplaneParamsType;
};
